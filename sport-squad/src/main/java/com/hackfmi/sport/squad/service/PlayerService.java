package com.hackfmi.sport.squad.service;

import com.hackfmi.sport.squad.dto.PlayerDto;
import com.hackfmi.sport.squad.web.controller.command.CreateUserCommand;

/**
 * Created by inakov on 14-11-8.
 */
public interface PlayerService {

    public PlayerDto findByEmail(String email);

    public PlayerDto createPlayer(CreateUserCommand createUserCommand);
}
