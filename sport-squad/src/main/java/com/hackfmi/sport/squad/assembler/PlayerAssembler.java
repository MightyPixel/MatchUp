package com.hackfmi.sport.squad.assembler;

import com.hackfmi.sport.squad.domain.Player;
import com.hackfmi.sport.squad.dto.PlayerDto;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

/**
 * Created by inakov on 14-11-8.
 */
@Component
public class PlayerAssembler extends BaseAssembler<Player, PlayerDto> {
    @Override
    protected Player createDocument() {
        return new Player();
    }

    @Override
    protected PlayerDto createDto() {
        return new PlayerDto();
    }

    @Override
    protected void convertToDto(Player player, PlayerDto playerDto) {
        playerDto.setAge(player.getAge());
        playerDto.setCity(player.getCity());
        playerDto.setEmail(player.getEmail());
        playerDto.setName(player.getName());
        playerDto.setId(player.getId().toString());
    }

    @Override
    protected void convertToDocument(Player player, PlayerDto playerDto) {
        player.setAge(playerDto.getAge());
        player.setCity(playerDto.getCity());
        player.setEmail(playerDto.getEmail());
        player.setName(playerDto.getName());
        player.setId(new ObjectId(playerDto.getId()));
    }
}
