package com.hackfmi.sport.squad.assembler;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackfmi.sport.squad.domain.Team;
import com.hackfmi.sport.squad.dto.TeamDto;

@Component
public class TeamAssembler extends BaseAssembler<Team, TeamDto> {
	
	@Autowired
	PlayerAssembler playerAssembler;
	
	@Override
	protected Team createDocument() {
		return new Team();
	}

	@Override
	protected TeamDto createDto() {
		return new TeamDto();
	}

	@Override
	protected void convertToDto(Team team, TeamDto teamDto) {
		teamDto.setId(team.getId().toString());
		teamDto.setName(team.getName());
		teamDto.setCaptainDto(playerAssembler.toDto(team.getCaptain()));
		teamDto.setSchedule(team.getSchedule());
		teamDto.setPlayersIds(objectIdToStringIdList(team.getPlayersIds()));
		teamDto.setRating(team.getRating());
		
	}

	@Override
	protected void convertToDocument(Team team, TeamDto teamDto) {
		team.setId(new ObjectId(teamDto.getId()));
		team.setName(teamDto.getName());
		team.setCaptain(playerAssembler.toDocument(teamDto.getCaptainDto()));
		team.setSchedule(teamDto.getSchedule());
		team.setPlayersIds(stringIdToObjectIdList(teamDto.getPlayersIds()));
		team.setRating(teamDto.getRating());
	}
	
	private List<String> objectIdToStringIdList(List<ObjectId> objectIds) {
		List<String> stringIds = new ArrayList<>();
		for (ObjectId objectId : objectIds) {
			stringIds.add(objectId.toString());
		}
		return stringIds;
	}
	
	private List<ObjectId> stringIdToObjectIdList(List<String> stringIds) {
		List<ObjectId> objectIds = new ArrayList<>();
		for (String stringId : stringIds) {
			objectIds.add(new ObjectId(stringId));
		}
		return objectIds;
	}

}
