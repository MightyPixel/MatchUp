package com.hackfmi.sport.squad.service.impl;

import com.hackfmi.sport.squad.repository.GameFieldRepository;
import com.hackfmi.sport.squad.service.GameFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by inakov on 14-11-8.
 */
@Service
public class GameFieldServiceImpl implements GameFieldService {

    @Autowired
    private GameFieldRepository gameFieldRepository;
}
