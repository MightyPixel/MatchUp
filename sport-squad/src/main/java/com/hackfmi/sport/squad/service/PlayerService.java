package com.hackfmi.sport.squad.service;

import com.hackfmi.sport.squad.domain.Player;

/**
 * Created by inakov on 14-11-8.
 */
public interface PlayerService {

    public Player findByEmail(String email);
}
