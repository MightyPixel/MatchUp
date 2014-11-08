package com.hackfmi.sport.squad.service;

import com.hackfmi.sport.squad.domain.Game;
import com.hackfmi.sport.squad.web.controller.command.CreateGameCommand;

/**
 * Created by inakov on 14-11-8.
 */
public interface GameService {

    public Game findGameById(String id);
    public Game createGame(CreateGameCommand createGameCommand);
}
