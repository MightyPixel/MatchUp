package com.hackfmi.sport.squad.service.impl;

import com.hackfmi.sport.squad.domain.*;
import java.sql.Timestamp;

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

    @Override
    public GameDto findGameById(String id) {
        return gameAssembler.toDto(gameRepository.findOne(new ObjectId(id)));
    }

    @Override
    public GameDto createGame(CreateGameCommand createGameCommand) {

        Game game = createGameCommandToGame(createGameCommand);
        return gameAssembler.toDto(gameRepository.save(game));
    }

    private Game createGameCommandToGame(CreateGameCommand createGameCommand){
        Game game = new Game();
        game.setStartDate(createGameCommand.getStartDate());
        game.setSport(createGameCommand.getSport());
        game.setPlayersPositions(createGameCommand.getPlayersPositions());
        game.setCreationDate(new Timestamp(System.currentTimeMillis()));
        game.setType(createGameCommand.getType());

        game.setGameField(gameFieldRepository.findOne(createGameCommand.getGameFieldId()));
        for(Team team : teamRepository.findAll(createGameCommand.getTeamsIds())){
            game.getTeams().add(team);
        }

        return game;
    }

//    private List<TimelineEventDto> listEventsForPlayer(String playerId){
//        Page<GameField> gameFieldPage = gameFieldRepository.findByCity(city, new PageRequest(page, size, sort));
//
//        return null;
//    }
}
