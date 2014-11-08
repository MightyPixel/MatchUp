package com.hackfmi.sport.squad.service.impl;

import com.hackfmi.sport.squad.repository.GameRepository;
import com.hackfmi.sport.squad.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by inakov on 14-11-8.
 */
@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;
}
