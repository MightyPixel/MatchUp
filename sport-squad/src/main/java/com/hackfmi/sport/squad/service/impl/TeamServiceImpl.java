package com.hackfmi.sport.squad.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.hackfmi.sport.squad.domain.Player;
import com.hackfmi.sport.squad.repository.PlayerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfmi.sport.squad.assembler.TeamAssembler;
import com.hackfmi.sport.squad.domain.Daytime;
import com.hackfmi.sport.squad.domain.ScheduleInterval;
import com.hackfmi.sport.squad.domain.Team;
import com.hackfmi.sport.squad.dto.TeamDto;
import com.hackfmi.sport.squad.repository.TeamRepository;
import com.hackfmi.sport.squad.service.TeamService;
import com.hackfmi.sport.squad.web.controller.command.CreateTeamCommand;
import com.hackfmi.sport.squad.web.controller.command.Moments;

/**
 * Created by inakov on 14-11-8.
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;
    
    @Autowired
    private TeamAssembler teamAssembler;

    @Override
    public TeamDto createTeam(CreateTeamCommand newTeam, String playerId) {
        Player player = playerRepository.findOne(new ObjectId(playerId));
        Team team = new Team();
        team.setCaptain(player);
        team.setName(newTeam.getTeamName());
        team.setCity(newTeam.getCity());
        for(String id : newTeam.getMembersIds()){
            team.getPlayersIds().add(new ObjectId(id));
        }

        for(Moments moment : newTeam.getSchedule()){
            if(moment.getHour() == null){
                team.getSchedule().add(new ScheduleInterval(moment.getDay(), Daytime.IRRELEVANT));
            }else if(moment.getHour() < 11){
                team.getSchedule().add(new ScheduleInterval(moment.getDay(), Daytime.MORNING));
            }else if(moment.getHour() < 17){
                team.getSchedule().add(new ScheduleInterval(moment.getDay(), Daytime.NOON));
            }else {
                team.getSchedule().add(new ScheduleInterval(moment.getDay(), Daytime.EVENING));
            }
        }
        return teamAssembler.toDto(teamRepository.save(team));
    }

    @Override
    public List<TeamDto> findByNameLike(String name) {
        return teamAssembler.toDtos(teamRepository.findByNameLike(name));
    }

	@Override
	public TeamDto findById(String id) {
		return teamAssembler.toDto(teamRepository.findOne(new ObjectId(id)));
	}

	@Override
	public List<TeamDto> getTeamsByCity(String city) {
		return teamAssembler.toDtos(teamRepository.findByCity(city));
	}
	
	public List<TeamDto> getMatchingTeams(TeamDto teamDto) {
		List<Team> matchingTeams = new ArrayList<>();
		Team team = teamAssembler.toDocument(teamDto);
		
		List<Team> teamsInCity = teamRepository.findByCityAndIdNot(team.getCity(), team.getId());
		for (Team teamInCity : teamsInCity) { 
			if(isScheduleMatching(team, teamInCity)) {
				matchingTeams.add(teamInCity);
			}
		}
		
		List<TeamDto> matchingTeamsDto = teamAssembler.toDtos(matchingTeams);
	    Collections.sort(matchingTeamsDto, new Comparator<TeamDto>() {

	        public int compare(TeamDto firstTeam, TeamDto secondTeam) {
	            return secondTeam.getRating().compareTo(firstTeam.getRating());
	        }
	    });
	    
	    return matchingTeamsDto;
	}
	
	private boolean isScheduleMatching(Team firstTeam, Team secondTeam) {
		for (ScheduleInterval firstTeamSchedule : firstTeam.getSchedule()) {
			for (ScheduleInterval secondTeamSchedule : secondTeam.getSchedule()) {
				if (firstTeamSchedule.matches(secondTeamSchedule)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public List<TeamDto> findTeamsForPlayer(String id) {
		return teamAssembler.toDtos(teamRepository.findByPlayersIdsIn(new ObjectId(id)));
	}

}
