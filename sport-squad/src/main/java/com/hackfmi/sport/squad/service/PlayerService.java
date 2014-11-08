package com.hackfmi.sport.squad.service;

import com.hackfmi.sport.squad.domain.Player;
import com.hackfmi.sport.squad.dto.PlayerDto;

/**
 * Created by inakov on 14-11-8.
 */
public interface PlayerService {

    public PlayerDto findByEmail(String email);
}
