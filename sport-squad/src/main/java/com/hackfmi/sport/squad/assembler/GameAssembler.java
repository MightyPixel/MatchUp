package com.hackfmi.sport.squad.assembler;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackfmi.sport.squad.domain.Game;
import com.hackfmi.sport.squad.dto.GameDto;

@Component
public class GameAssembler extends BaseAssembler<Game, GameDto> {
	
	@Autowired
	private GameFieldAssembler gameFieldAssembler;
	@Autowired
	private TeamAssembler teamAssembler;
	@Autowired
	private PlayerPositionAssembler playerPositionAssembler;

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
		gameDto.setChallengedTeamPositionsDto(playerPositionAssembler.toDtos(game.getChallengedTeamPositions()));
        gameDto.setChallengerTeamPositionsDto(playerPositionAssembler.toDtos(game.getChallengerTeamPositions()));
        gameDto.setGameFieldDto(gameFieldAssembler.toDto(game.getGameField()));
		gameDto.setChallengedTeam(teamAssembler.toDto(game.getChallengedTeam()));
        gameDto.setChallengerTeam(teamAssembler.toDto(game.getChallengerTeam()));
	}

	@Override
	protected void convertToDocument(Game game, GameDto gameDto) {
		game.setId(new ObjectId(gameDto.getId()));
		game.setType(gameDto.getType());
		game.setSport(gameDto.getSport());
		game.setState(gameDto.getState());
		game.setStartDate(gameDto.getStartDate());
		game.setCreationDate(gameDto.getCreationDate());
        game.setChallengedTeamPositions(playerPositionAssembler.toDocuments(gameDto.getChallengedTeamPositionsDto()));
        game.setChallengerTeamPositions(playerPositionAssembler.toDocuments(gameDto.getChallengerTeamPositionsDto()));
        game.setGameField(gameFieldAssembler.toDocument(gameDto.getGameFieldDto()));
        game.setChallengedTeam(teamAssembler.toDocument(gameDto.getChallengedTeam()));
        game.setChallengerTeam(teamAssembler.toDocument(gameDto.getChallengerTeam()));
	}

    public PlayerPositionAssembler getPlayerPositionAssembler() {
        return playerPositionAssembler;
    }
}
