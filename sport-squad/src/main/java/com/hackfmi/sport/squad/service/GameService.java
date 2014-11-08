package com.hackfmi.sport.squad.service;

import com.hackfmi.sport.squad.dto.GameDto;
import com.hackfmi.sport.squad.web.controller.command.CreateGameCommand;

/**
 * Created by inakov on 14-11-8.
 */
public interface GameService {

    public GameDto findGameById(String id);
    public GameDto createGame(CreateGameCommand createGameCommand);
}
