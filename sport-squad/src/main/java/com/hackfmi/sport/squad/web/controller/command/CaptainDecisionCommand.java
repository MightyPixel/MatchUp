package com.hackfmi.sport.squad.web.controller.command;

import com.hackfmi.sport.squad.dto.PlayerPositionDto;

import java.util.List;

/**
 * Created by inakov on 14-11-9.
 */
public class CaptainDecisionCommand {

    private String gameId;
    private String eventId;
    private Boolean accept;
    private List<PlayerPositionDto> playerPositions;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public List<PlayerPositionDto> getPlayerPositions() {
        return playerPositions;
    }

    public void setPlayerPositions(List<PlayerPositionDto> playerPositions) {
        this.playerPositions = playerPositions;
    }

    public Boolean getAccept() {
        return accept;
    }

    public void setAccept(Boolean accept) {
        this.accept = accept;
    }
}
