package com.hackfmi.sport.squad.service;

import java.util.List;

import com.hackfmi.sport.squad.dto.TeamDto;
import com.hackfmi.sport.squad.web.controller.command.CreateTeamCommand;

/**
 * Created by inakov on 14-11-8.
 */
public interface TeamService {

    public TeamDto createTeam(CreateTeamCommand newTeam, String playerId);
    public TeamDto findById(String id);

    public List<TeamDto> findByNameLike(String name);
    public List<TeamDto> getTeamsByCity(String city);
    public List<TeamDto> getMatchingTeams(TeamDto teamDto);
    public List<TeamDto> findTeamsForPlayer(String id);
    
}
