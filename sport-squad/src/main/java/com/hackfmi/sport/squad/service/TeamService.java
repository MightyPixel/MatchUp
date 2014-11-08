package com.hackfmi.sport.squad.service;

import com.hackfmi.sport.squad.domain.Team;
import com.hackfmi.sport.squad.web.controller.command.CreateTeamCommand;

import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
public interface TeamService {

    public Team createTeam(CreateTeamCommand newTeam);

    public List<Team> getTeamsByNameLike(String name);
}
