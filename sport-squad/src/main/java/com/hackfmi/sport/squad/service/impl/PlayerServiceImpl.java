package com.hackfmi.sport.squad.service.impl;

import com.hackfmi.sport.squad.domain.Player;
import com.hackfmi.sport.squad.repository.PlayerRepository;
import com.hackfmi.sport.squad.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by inakov on 14-11-8.
 */

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player findByEmail(String email) {
        return playerRepository.findByEmail(email);
    }
}
