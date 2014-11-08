package com.hackfmi.sport.squad.dto;

import java.util.ArrayList;
import java.util.List;

import com.hackfmi.sport.squad.domain.ScheduleInterval;

public class TeamDto implements BaseDto {
	
	private String id;

    private String name;

    private PlayerDto captainDto;
    private List<ScheduleInterval> schedule = new ArrayList<>();
    private List<String> playersIds = new ArrayList<>();

    private Double rating = 0d;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerDto getCaptainDto() {
		return captainDto;
	}

	public void setCaptainDto(PlayerDto captainDto) {
		this.captainDto = captainDto;
	}

	public List<ScheduleInterval> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<ScheduleInterval> schedule) {
		this.schedule = schedule;
	}

	public List<String> getPlayersIds() {
		return playersIds;
	}

	public void setPlayersIds(List<String> playersIds) {
		this.playersIds = playersIds;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
}
