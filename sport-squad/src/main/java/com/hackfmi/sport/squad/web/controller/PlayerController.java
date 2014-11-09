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

    @RequestMapping(method = RequestMethod.GET, value = "/player/{email}")
    public ResponseEntity<PlayerDto> findByEmail(@PathVariable String email){
        return new ResponseEntity<PlayerDto>(playerService.findByEmail(email), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/player/create", consumes = "application/json")
    public ResponseEntity<PlayerDto> createTeam(@RequestBody CreateUserCommand createUserCommand){
        PlayerDto playerDto = playerService.createPlayer(createUserCommand);
        return new ResponseEntity<PlayerDto>(playerDto, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/player/find", params = {"namePattern"})
    public List<PlayerDto> findByNameLike(@RequestParam String namePattern){
        return playerService.findByNameLike(namePattern);
    }

}
