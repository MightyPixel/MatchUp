package com.hackfmi.sport.squad.assembler;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.hackfmi.sport.squad.domain.PlayerPosition;
import com.hackfmi.sport.squad.dto.PlayerPositionDto;

@Component
public class PlayerPositionAssembler extends
		BaseAssembler<PlayerPosition, PlayerPositionDto> {

	@Override
	protected PlayerPosition createDocument() {
		return new PlayerPosition();
	}

	@Override
	protected PlayerPositionDto createDto() {
		return new PlayerPositionDto();
	}

	@Override
	protected void convertToDto(PlayerPosition playerPosition,
			PlayerPositionDto playerPositionDto) {
		playerPositionDto.setId(playerPosition.getPlayerId().toString());
		playerPositionDto.setGamePosition(playerPosition.getGamePosition());
	}

	@Override
	protected void convertToDocument(PlayerPosition playerPosition,
			PlayerPositionDto playerPositionDto) {
		playerPosition.setPlayerId(new ObjectId(playerPositionDto.getId()));
		playerPosition.setGamePosition(playerPositionDto.getGamePosition());
	}

}
