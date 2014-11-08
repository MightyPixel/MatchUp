package com.hackfmi.sport.squad.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    
    @RequestMapping(method = RequestMethod.GET, value = "/player/find", params = {"namePattern"})
    public List<PlayerDto> findByNameLike(@RequestParam String namePattern){
        return playerService.findByNameLike(namePattern);
    }

}
