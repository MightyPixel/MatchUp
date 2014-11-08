package com.hackfmi.sport.squad.service;

import java.util.List;

import com.hackfmi.sport.squad.dto.TeamDto;
import com.hackfmi.sport.squad.web.controller.command.CreateTeamCommand;

/**
 * Created by inakov on 14-11-8.
 */
public interface TeamService {

    public TeamDto createTeam(CreateTeamCommand newTeam);

    public List<TeamDto> getTeamsByNameLike(String name);
}
