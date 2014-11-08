package com.hackfmi.sport.squad.assembler;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackfmi.sport.squad.domain.Game;
import com.hackfmi.sport.squad.dto.GameDto;

@Component
public class GameAssembler extends BaseAssembler<Game, GameDto> {
	
	@Autowired
	GameFieldAssembler gameFieldAssembler;
	@Autowired
	TeamAssembler teamAssembler;
	@Autowired
	PlayerPositionAssembler playerPositionAssembler;

	@Override
	protected Game createDocument() {
		return new Game();
	}

	@Override
	protected GameDto createDto() {
		return new GameDto();
	}

	@Override
	protected void convertToDto(Game game, GameDto gameDto) {
		gameDto.setId(game.getId().toString());
		gameDto.setType(game.getType());
		gameDto.setSport(game.getSport());
		gameDto.setState(game.getState());
		gameDto.setStartDate(game.getStartDate());
		gameDto.setCreationDate(game.getCreationDate());
		gameDto.setPlayersPositionsDto(playerPositionAssembler.toDtos(game.getPlayersPositions()));
		gameDto.setGameFieldDto(gameFieldAssembler.toDto(game.getGameField()));
		gameDto.setTeamsDto(teamAssembler.toDtos(game.getTeams()));
	}

	@Override
	protected void convertToDocument(Game game, GameDto gameDto) {
		game.setId(new ObjectId(gameDto.getId()));
		game.setType(gameDto.getType());
		game.setSport(gameDto.getSport());
		game.setState(gameDto.getState());
		game.setStartDate(gameDto.getStartDate());
		game.setCreationDate(gameDto.getCreationDate());
		game.setPlayersPositions(playerPositionAssembler.toDocuments(gameDto.getPlayersPositionsDto()));
		game.setGameField(gameFieldAssembler.toDocument(gameDto.getGameFieldDto()));
		game.setTeams(teamAssembler.toDocuments(gameDto.getTeamsDto()));
	}

}
