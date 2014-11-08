package com.hackfmi.sport.squad.web.controller;

import com.hackfmi.sport.squad.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by inakov on 14-11-8.
 */
@RestController
@RequestMapping("/service")
public class GameController {

    @Autowired
    private GameService gameService;
}
