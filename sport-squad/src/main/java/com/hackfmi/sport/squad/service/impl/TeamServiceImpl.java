package com.hackfmi.sport.squad.service.impl;

import com.hackfmi.sport.squad.repository.TeamRepository;
import com.hackfmi.sport.squad.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by inakov on 14-11-8.
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
}
