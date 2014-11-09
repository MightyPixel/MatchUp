package com.hackfmi.sport.squad.web.controller;

import com.hackfmi.sport.squad.dto.TimelineEventDto;
import com.hackfmi.sport.squad.web.controller.command.CaptainDecisionCommand;
import com.hackfmi.sport.squad.web.controller.command.DeclareScoreCommand;
import com.hackfmi.sport.squad.web.controller.command.InvitationDecisionCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    
    @RequestMapping(method = RequestMethod.GET, value = "/get", params = {"id"}, produces = "application/json")
    public ResponseEntity<GameDto> getGameById(@RequestParam String id){
    	return new ResponseEntity<GameDto>(gameService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = "application/json")
    public ResponseEntity<GameDto> createGame(@RequestBody CreateGameCommand createGameCommand){
        GameDto game = gameService.createGame(createGameCommand);
        return new ResponseEntity<GameDto>(game, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/invitation", consumes = "application/json")
    public ResponseEntity<TimelineEventDto> gameInvitationResponse(@RequestBody InvitationDecisionCommand decisionCommand){
        //TODO: get playerId by spring context!!!!!
        TimelineEventDto response = gameService.handleInvitationDecisionCommand(decisionCommand,new Object().toString());
        return new ResponseEntity<TimelineEventDto>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/captain-decision", consumes = "application/json")
    public ResponseEntity<TimelineEventDto> processCaptainDecision(@RequestBody CaptainDecisionCommand decisionCommand){
        //TODO: get playerId by spring context!!!!!
        TimelineEventDto response = gameService.handleCaptainDecisionCommand(decisionCommand, new Object().toString());
        return new ResponseEntity<TimelineEventDto>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/declare-score", consumes = "application/json")
    public ResponseEntity<TimelineEventDto> declareScore(@RequestBody DeclareScoreCommand declareScoreCommand){
        //TODO: get playerId by spring context!!!!!
        TimelineEventDto response = gameService.handleDeclareScoreCommand(declareScoreCommand,new Object().toString());
        return new ResponseEntity<TimelineEventDto>(response, HttpStatus.OK);
    }
}
