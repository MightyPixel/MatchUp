package com.hackfmi.sport.squad.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackfmi.sport.squad.domain.Game;
import com.hackfmi.sport.squad.dto.GameDto;
import com.hackfmi.sport.squad.service.GameService;
import com.hackfmi.sport.squad.web.controller.command.CreateGameCommand;

/**
 * Created by inakov on 14-11-8.
 */
@RestController
@RequestMapping("/service/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = "application/json")
    public ResponseEntity<GameDto> createTeam(@RequestBody CreateGameCommand createGameCommand){
        GameDto game = gameService.createGame(createGameCommand);
        return new ResponseEntity<GameDto>(game, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<GameDto> createTeam(@PathVariable String id){
        GameDto game = gameService.findGameById(id);
        return new ResponseEntity<GameDto>(game, HttpStatus.OK);
    }

}
