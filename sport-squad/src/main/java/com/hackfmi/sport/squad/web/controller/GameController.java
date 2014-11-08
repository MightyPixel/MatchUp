package com.hackfmi.sport.squad.web.controller;

import com.hackfmi.sport.squad.domain.Game;
import com.hackfmi.sport.squad.domain.Team;
import com.hackfmi.sport.squad.service.GameService;
import com.hackfmi.sport.squad.web.controller.command.CreateGameCommand;
import com.hackfmi.sport.squad.web.controller.command.CreateTeamCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by inakov on 14-11-8.
 */
@RestController
@RequestMapping("/service/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = "application/json")
    public ResponseEntity<Game> createTeam(@RequestBody CreateGameCommand createGameCommand){
        Game game = gameService.createGame(createGameCommand);
        return new ResponseEntity<Game>(game, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Game> createTeam(@PathVariable String id){
        Game game = gameService.findGameById(id);
        return new ResponseEntity<Game>(game, HttpStatus.OK);
    }

}
