package com.hackfmi.sport.squad.web.controller;

import com.hackfmi.sport.squad.domain.Player;
import com.hackfmi.sport.squad.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by inakov on 14-11-8.
 */

@RestController
@RequestMapping("/service")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET, value = "/player/{email}")
    public ResponseEntity<Player> findByEmail(@PathVariable String email){
        return new ResponseEntity<Player>(playerService.findByEmail(email), HttpStatus.OK);
    }

}
