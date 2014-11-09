package com.hackfmi.sport.squad.service.impl;

import com.hackfmi.sport.squad.domain.*;
import java.sql.Timestamp;

import com.hackfmi.sport.squad.service.TimelineEventService;
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
    private TimelineEventService timelineEventService;

    @Override
    public GameDto findById(String id) {
        return gameAssembler.toDto(gameRepository.findOne(new ObjectId(id)));
    }

    @Override
    public GameDto createGame(CreateGameCommand createGameCommand) {

        Game game = createGameCommandToGame(createGameCommand);
        notifyAllPlayers(game.getChallengerTeam(), game.getChallengedTeam(), game.getId());

        //TODO: Create notification for gameResult
        return gameAssembler.toDto(gameRepository.save(game));
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
                    addPlayerMatchInvitationEvent(playerId.toString(), "You have match ...", gameId.toString(), false);
        }
        for(ObjectId playerId : teamTwo.getPlayersIds()){
            timelineEventService.
                    addPlayerMatchInvitationEvent(playerId.toString(), "You have match ...", gameId.toString(), false);
        }
        timelineEventService.
                addPlayerMatchInvitationEvent(teamOne.getCaptain().getId().toString(),
                        "Select players positions ...", gameId.toString(), true);
        timelineEventService.
                addPlayerMatchInvitationEvent(teamTwo.getCaptain().getId().toString(),
                        "You have match ... Select players positions", gameId.toString(), true);

    }

//    private List<TimelineEventDto> listEventsForPlayer(String playerId){
//        Page<GameField> gameFieldPage = gameFieldRepository.findByCity(city, new PageRequest(page, size, sort));
//
//        return null;
//    }
}
