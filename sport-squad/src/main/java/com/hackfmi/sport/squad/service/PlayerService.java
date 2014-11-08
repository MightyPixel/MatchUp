package com.hackfmi.sport.squad.service;

import java.util.List;

import com.hackfmi.sport.squad.dto.PlayerDto;

/**
 * Created by inakov on 14-11-8.
 */
public interface PlayerService {

    public PlayerDto findByEmail(String email);
	public List<PlayerDto> findByNameLike(String namePattern);
}
