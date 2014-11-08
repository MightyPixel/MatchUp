package com.hackfmi.sport.squad.service.impl;

import com.hackfmi.sport.squad.assembler.TeamAssembler;
import com.hackfmi.sport.squad.domain.Daytime;
import com.hackfmi.sport.squad.domain.ScheduleInterval;
import com.hackfmi.sport.squad.domain.Team;
import com.hackfmi.sport.squad.dto.TeamDto;
import com.hackfmi.sport.squad.repository.TeamRepository;
import com.hackfmi.sport.squad.service.TeamService;
import com.hackfmi.sport.squad.web.controller.command.CreateTeamCommand;
import com.hackfmi.sport.squad.web.controller.command.Moments;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
    
    @Autowired
    private TeamAssembler teamAssembler;

    @Override
    public TeamDto createTeam(CreateTeamCommand newTeam) {
        Team team = new Team();
        team.setId(new ObjectId());
        team.setName(newTeam.getTeamName());
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
    public List<TeamDto> getTeamsByNameLike(String name) {
        return teamAssembler.toDtos(teamRepository.findByNameLike(name));
    }


}
