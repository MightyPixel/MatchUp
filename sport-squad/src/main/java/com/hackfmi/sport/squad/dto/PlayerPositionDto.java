package com.hackfmi.sport.squad.dto;


public class PlayerPositionDto implements BaseDto {
	
    private String playerId;
    private Integer gamePosition;

	@Override
	public String getId() {
		return playerId;
	}

	@Override
	public void setId(String playerId) {
		this.playerId = playerId;
	}

	public Integer getGamePosition() {
		return gamePosition;
	}

	public void setGamePosition(Integer gamePosition) {
		this.gamePosition = gamePosition;
	}
	
}
