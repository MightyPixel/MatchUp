package com.hackfmi.sport.squad.dto;

import java.sql.Timestamp;
import java.util.List;

import com.hackfmi.sport.squad.domain.GameState;
import com.hackfmi.sport.squad.domain.GameType;
import com.hackfmi.sport.squad.domain.Sport;

public class GameDto implements BaseDto {

	private String id;
	private GameType type;
	private Sport sport;
	private GameState state;

	private Timestamp startDate;
	private Timestamp creationDate;

	private List<PlayerPositionDto> playersPositionsDto;

	private GameFieldDto gameFieldDto;

	private List<TeamDto> teamsDto;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public GameType getType() {
		return type;
	}

	public void setType(GameType type) {
		this.type = type;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public GameState getState() {
		return state;
	}

	public void setState(GameState state) {
		this.state = state;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public List<PlayerPositionDto> getPlayersPositionsDto() {
		return playersPositionsDto;
	}

	public void setPlayersPositionsDto(List<PlayerPositionDto> playersPositionsDto) {
		this.playersPositionsDto = playersPositionsDto;
	}

	public GameFieldDto getGameFieldDto() {
		return gameFieldDto;
	}

	public void setGameFieldDto(GameFieldDto gameFieldDto) {
		this.gameFieldDto = gameFieldDto;
	}

	public List<TeamDto> getTeamsDto() {
		return teamsDto;
	}

	public void setTeamsDto(List<TeamDto> teamsDto) {
		this.teamsDto = teamsDto;
	}

}
