package com.hackfmi.sport.squad.service.impl;

import com.google.common.collect.Lists;
import com.hackfmi.sport.squad.domain.*;
import java.sql.Timestamp;

import com.hackfmi.sport.squad.dto.PlayerPositionDto;
import com.hackfmi.sport.squad.dto.TimelineEventDto;
import com.hackfmi.sport.squad.service.PlayerService;
import com.hackfmi.sport.squad.service.TimelineEventService;
import com.hackfmi.sport.squad.web.controller.command.CaptainDecisionCommand;
import com.hackfmi.sport.squad.web.controller.command.DeclareScoreCommand;
import com.hackfmi.sport.squad.web.controller.command.InvitationDecisionCommand;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfmi.sport.squad.assembler.GameAssembler;
import com.hackfmi.sport.squad.domain.Game;
import com.hackfmi.sport.squad.domain.Team;
import com.hackfmi.sport.squad.dto.GameDto;
import com.hackfmi.sport.squad.repository.GameFieldRepository;
import com.hackfmi.sport.squad.repository.GameRepository;
import com.hackfmi.sport.squad.repository.PlayerRepository;
import com.hackfmi.sport.squad.repository.TeamRepository;
import com.hackfmi.sport.squad.service.GameService;
import com.hackfmi.sport.squad.web.controller.command.CreateGameCommand;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameFieldRepository gameFieldRepository;
    @Autowired
    private TeamRepository teamRepository;
    
    @Autowired
    private GameAssembler gameAssembler;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TimelineEventService timelineEventService;

    @Override
    public GameDto findById(String id) {
        return gameAssembler.toDto(gameRepository.findOne(new ObjectId(id)));
    }

    @Override
    public GameDto createGame(CreateGameCommand createGameCommand) {

        Game game = createGameCommandToGame(createGameCommand);
        ObjectId gameId = gameRepository.save(game).getId();
        game.setId(gameId);
        notifyAllPlayers(game.getChallengerTeam(), game.getChallengedTeam(), game.getId());
        createScoreEvents(game);

        return gameAssembler.toDto(gameRepository.save(game));
    }

    private void createScoreEvents(Game game) {
        Team challengedTeam = game.getChallengedTeam();
        Team challengerTeam = game.getChallengerTeam();
        String msg = "Please enter score!";
        timelineEventService.addEnterScoreEvent(challengedTeam.getCaptain().getId().toString(),
                msg, game.getId().toString(), false, challengedTeam.getName(), challengerTeam.getName(), game.getStartDate());
        timelineEventService.addEnterScoreEvent(challengerTeam.getCaptain().getId().toString(),
                msg, game.getId().toString(), false, challengedTeam.getName(), challengerTeam.getName(), game.getStartDate());
    }

    private Game createGameCommandToGame(CreateGameCommand createGameCommand){
        Game game = new Game();
        game.setStartDate(createGameCommand.getStartDate());
        game.setCreationDate(new Timestamp(System.currentTimeMillis()));

        game.setGameField(gameFieldRepository.findOne(new ObjectId(createGameCommand.getGameFieldId())));
        game.setChallengedTeam(teamRepository.findOne(new ObjectId(createGameCommand.getChallengedTeam())));
        game.setChallengerTeam(teamRepository.findOne(new ObjectId(createGameCommand.getChallengerTeam())));

        for(ObjectId playerId : game.getChallengedTeam().getPlayersIds()){
            GameInvitation gameInvitation = new GameInvitation();
            gameInvitation.setPlayerId(playerId);
            game.getGameInvitationsForChallengedTeam().add(gameInvitation);
        }

        for(ObjectId playerId : game.getChallengerTeam().getPlayersIds()){
            GameInvitation gameInvitation = new GameInvitation();
            gameInvitation.setPlayerId(playerId);
            game.getGameInvitationsForChallengerTeam().add(gameInvitation);
        }

        return game;
    }

    private void notifyAllPlayers(Team teamOne, Team teamTwo, ObjectId gameId){
        for(ObjectId playerId : teamOne.getPlayersIds()){
            timelineEventService.
                    addPlayerMatchInvitationEvent(playerId.toString(), "You have match ...", gameId.toString(),
                            false, teamOne.getName(), teamTwo.getName());
        }
        for(ObjectId playerId : teamTwo.getPlayersIds()){
            timelineEventService.
                    addPlayerMatchInvitationEvent(playerId.toString(), "You have match ...", gameId.toString(),
                            false, teamOne.getName(), teamTwo.getName());
        }
        timelineEventService.
                addPlayerMatchInvitationEvent(teamOne.getCaptain().getId().toString(),
                        "Select players positions ...", gameId.toString(), true, teamOne.getName(), teamTwo.getName());
        timelineEventService.
                addPlayerMatchInvitationEvent(teamTwo.getCaptain().getId().toString(),
                        "You have match ... Select players positions", gameId.toString(),
                        true, teamOne.getName(), teamTwo.getName());

    }

    @Override
    public TimelineEventDto handleInvitationDecisionCommand(InvitationDecisionCommand command, String playerId) {
        Game game = gameRepository.findOne(new ObjectId(command.getGameId()));
        if(game == null){
            updatePlayerInvitation(game, new ObjectId(playerId));
            gameRepository.save(game);

            return timelineEventService.processGameInvitation(command);
        }
        return null;
    }

    private void updatePlayerInvitation(Game game, ObjectId playerId){
        for(GameInvitation gameInvitation : game.getGameInvitationsForChallengedTeam()){
            if(gameInvitation.getPlayerId().equals(playerId)){
                gameInvitation.setStatus(InvitationStatus.ACCEPTED);
            }
        }
        for(GameInvitation gameInvitation : game.getGameInvitationsForChallengerTeam()){
            if(gameInvitation.getPlayerId().equals(playerId)){
                gameInvitation.setStatus(InvitationStatus.ACCEPTED);
            }
        }
    }

    @Override
    public TimelineEventDto handleCaptainDecisionCommand(CaptainDecisionCommand command, String playerId) {
        Game game = gameRepository.findOne(new ObjectId(command.getGameId()));
        if(game != null){
            List<PlayerPositionDto> positionDtos = command.getPlayerPositions();
            if(positionDtos != null && !positionDtos.isEmpty()){
                if(game.getChallengedTeam().getCaptain().getId().equals(new ObjectId(playerId))){
                    game.setChallengedTeamPositions(
                            gameAssembler.getPlayerPositionAssembler().toDocuments(command.getPlayerPositions()));
                }else if(game.getChallengerTeam().getCaptain().getId().equals(new ObjectId(playerId))){
                    game.setChallengerTeamPositions(
                            gameAssembler.getPlayerPositionAssembler().toDocuments(command.getPlayerPositions()));
                }
            }
            if(command.getAccept() != null && !command.getAccept()){
                game.setState(GameState.CANCELED);
            }
            gameRepository.save(game);
        }

        return null;
    }

    @Override
    public TimelineEventDto handleDeclareScoreCommand(DeclareScoreCommand declareScoreCommand, String playerId) {
        Game game = gameRepository.findOne(new ObjectId(declareScoreCommand.getGameId()));
        if(game != null){
            declareChallengedTeamScore(game, new ObjectId(playerId),declareScoreCommand.getGameScore());
            declareChallengerTeamScore(game, new ObjectId(playerId),declareScoreCommand.getGameScore());
            finalizeGameScore(game);
            gameRepository.save(game);
        }
        return null;
    }

    private void declareChallengerTeamScore(Game game, ObjectId playerId, GameScore gameScore){
        if(game.getChallengerTeam().getCaptain().getId().equals(playerId)){
            game.setChallengerTeamScoreDeclared(gameScore);
        }
    }

    private void declareChallengedTeamScore(Game game, ObjectId playerId, GameScore gameScore){
        if(game.getChallengedTeam().getCaptain().getId().equals(playerId)){
            game.setChallengedTeamScoreDeclared(gameScore);
        }
    }

    private void finalizeGameScore(Game game){
        if(game.getChallengedTeamScoreDeclared() != null && game.getChallengerTeamScoreDeclared() != null){
            if(game.getChallengedTeamScoreDeclared() == game.getChallengerTeamScoreDeclared()){
                game.setGameScore(game.getChallengedTeamScoreDeclared());
                game.setState(GameState.FINISHED);
                updateRating(game);
            }else{
                game.setState(GameState.CONFLICT);
                updateRating(game);
            }
        }

    }

    private void updateRating(Game game) {
        if(game.getState() != null && game.getState() == GameState.FINISHED){
            Integer challengerScore =  game.getGameScore().getChallengerTeamScore();
            Integer challengedScore =  game.getGameScore().getChallengedTeamScore();
            Double challengerRating = game.getChallengerTeam().getRating();
            Double challengedRating = game.getChallengedTeam().getRating();
            if(challengedScore.equals(challengedScore)){
                challengedRating +=50;
                challengerRating +=50;
            }else if(challengedScore > challengedScore){
                challengedRating += 100;
            }else {
                challengerRating += 100;
            }
            game.getChallengerTeam().setRating(challengerRating);
            game.getChallengedTeam().setRating(challengedRating);
            teamRepository.save(game.getChallengerTeam());
            teamRepository.save(game.getChallengedTeam());
        }else if(game.getState() != null && game.getState() == GameState.CONFLICT){
            Double challengerRating = game.getChallengerTeam().getRating() - 200;
            Double challengedRating = game.getChallengedTeam().getRating() - 200;
            game.getChallengerTeam().setRating(challengerRating);
            game.getChallengedTeam().setRating(challengedRating);
            teamRepository.save(game.getChallengerTeam());
            teamRepository.save(game.getChallengedTeam());
        }
    }

    private void notifyPlayersForGameChange(Game game){
        List<Player> challengedTeamPlayers = Lists.newArrayList(playerRepository.findAll(game.getChallengedTeam().getPlayersIds()));
        List<Player> challengerTeamPlayers = Lists.newArrayList(playerRepository.findAll(game.getChallengerTeam().getPlayersIds()));
        if(game.getState() != null && game.getState() == GameState.FINISHED){
            for(Player player : challengedTeamPlayers){
                String msg = "Game Finished " + game.getGameScore().getChallengedTeamScore() + " : "
                        + game.getGameScore().getChallengerTeamScore();
                timelineEventService.addGameChangedEvent(player.getId().toString(), msg, game.getId().toString(), false,
                        game.getChallengedTeam().getName(),game.getChallengerTeam().getName());
            }
            for(Player player : challengerTeamPlayers){
                String msg = "Game Finished " + game.getGameScore().getChallengedTeamScore() + " : "
                        + game.getGameScore().getChallengerTeamScore();
                timelineEventService.addGameChangedEvent(player.getId().toString(), msg, game.getId().toString(), false,
                        game.getChallengedTeam().getName(),game.getChallengerTeam().getName());
            }
        }else if(game.getState() != null && game.getState() == GameState.CONFLICT){
            for(Player player : challengedTeamPlayers){
                String msg = "Game Finished with confilict your team lose 200 rating!";
                timelineEventService.addGameChangedEvent(player.getId().toString(), msg, game.getId().toString(), false,
                        game.getChallengedTeam().getName(),game.getChallengerTeam().getName());
            }
            for(Player player : challengerTeamPlayers){
                String msg = "Game Finished with confilict your team lose 200 rating!";
                timelineEventService.addGameChangedEvent(player.getId().toString(), msg, game.getId().toString(), false,
                        game.getChallengedTeam().getName(),game.getChallengerTeam().getName());
            }
        }else if(game.getState() != null && game.getState() == GameState.CANCELED){
            for(Player player : challengedTeamPlayers){
                String msg = "Game was canceled!";
                timelineEventService.addGameChangedEvent(player.getId().toString(), msg, game.getId().toString(), false,
                        game.getChallengedTeam().getName(),game.getChallengerTeam().getName());
            }
            for(Player player : challengerTeamPlayers){
                String msg = "Game was canceled!";
                timelineEventService.addGameChangedEvent(player.getId().toString(), msg, game.getId().toString(), false,
                        game.getChallengedTeam().getName(),game.getChallengerTeam().getName());
            }
        }
    }

    //    private List<TimelineEventDto> listEventsForPlayer(String playerId){
//        Page<GameField> gameFieldPage = gameFieldRepository.findByCity(city, new PageRequest(page, size, sort));
//
//        return null;
//    }
}
