package com.hackfmi.sport.squad.web.controller;

import java.util.List;

import com.hackfmi.sport.squad.web.controller.command.CreateUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hackfmi.sport.squad.dto.PlayerDto;
import com.hackfmi.sport.squad.service.PlayerService;

/**
 * Created by inakov on 14-11-8.
 */

@RestController
@RequestMapping("/service")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET, value = "/get", params = {"id"}, produces = "application/json")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable String id){
        return new ResponseEntity<PlayerDto>(playerService.findById(id), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/get", params = {"namePattern"}, produces = "application/json")
    public ResponseEntity<List<PlayerDto>> getPlayerByNameLike(@RequestParam String namePattern){
        return new ResponseEntity<List<PlayerDto>>(playerService.findByNameLike(namePattern), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/player/create", consumes = "application/json")
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody CreateUserCommand createUserCommand){
        PlayerDto playerDto = playerService.createPlayer(createUserCommand);
        return new ResponseEntity<PlayerDto>(playerDto, HttpStatus.OK);
    }

}
