package com.hackfmi.sport.squad.service.impl;

import java.util.List;

import com.hackfmi.sport.squad.assembler.PlayerAssembler;
import com.hackfmi.sport.squad.domain.Player;
import com.hackfmi.sport.squad.dto.PlayerDto;
import com.hackfmi.sport.squad.repository.PlayerRepository;
import com.hackfmi.sport.squad.service.PlayerService;
import com.hackfmi.sport.squad.web.controller.command.CreateUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by inakov on 14-11-8.
 */

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerAssembler playerAssembler;

    @Override
    public PlayerDto findByEmail(String email) {
        Player player = playerRepository.findByEmail(email);

        return playerAssembler.toDto(player);
    }

    @Override
    public PlayerDto createPlayer(CreateUserCommand createUserCommand) {
        Player newPlayer = new Player();
        newPlayer.setAge(createUserCommand.getAge());
        newPlayer.setCity(createUserCommand.getCity());
        newPlayer.setName(createUserCommand.getName());
        newPlayer.setPassword(createUserCommand.getPasswords());

        newPlayer = playerRepository.save(newPlayer);
        return playerAssembler.toDto(newPlayer);
    }

	@Override
	public List<PlayerDto> findByNameLike(String namePattern) {
		List<Player> playerList = playerRepository.findByNameLike(namePattern);
		return playerAssembler.toDtos(playerList);
	}
}
