package com.hackfmi.sport.squad.assembler;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.hackfmi.sport.squad.domain.GameField;
import com.hackfmi.sport.squad.dto.GameFieldDto;

@Component
public class GameFieldAssembler extends BaseAssembler<GameField, GameFieldDto> {

	@Override
	protected GameField createDocument() {
		return new GameField();
	}

	@Override
	protected GameFieldDto createDto() {
		return new GameFieldDto();
	}
	
	@Override
	protected void convertToDocument(GameField gameField, GameFieldDto gameFieldDto) {
		gameField.setId(new ObjectId(gameFieldDto.getId()));
		gameField.setName(gameFieldDto.getName());
		gameField.setCity(gameFieldDto.getCity());
		gameField.setDescription(gameFieldDto.getDescription());
		gameField.setRating(gameFieldDto.getRating());
		gameField.setCapacity(gameFieldDto.getCapacity());
		gameField.setImgPath(gameFieldDto.getImgPath());
	}

	@Override
	protected void convertToDto(GameField gameField, GameFieldDto gameFieldDto) {
		gameFieldDto.setId(gameField.getId().toString());
		gameFieldDto.setName(gameField.getName());
		gameFieldDto.setCity(gameField.getCity());
		gameFieldDto.setDescription(gameField.getDescription());
		gameFieldDto.setRating(gameField.getRating());
		gameFieldDto.setCapacity(gameField.getCapacity());
		gameFieldDto.setImgPath(gameField.getImgPath());
	}

}
