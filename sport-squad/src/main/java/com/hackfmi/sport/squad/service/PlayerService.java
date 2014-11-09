package com.hackfmi.sport.squad.service;

import java.util.List;

import com.hackfmi.sport.squad.dto.PlayerDto;
import com.hackfmi.sport.squad.web.controller.command.CreateUserCommand;

/**
 * Created by inakov on 14-11-8.
 */
public interface PlayerService {

    public PlayerDto findById(String id);
    public PlayerDto createPlayer(CreateUserCommand createUserCommand);
	public List<PlayerDto> findByNameLike(String namePattern);
}
