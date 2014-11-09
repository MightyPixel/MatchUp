package com.hackfmi.sport.squad.web.controller.command;

/**
 * Created by inakov on 14-11-9.
 */
public class InvitationDecisionCommand {

    private String gameId;
    private String eventId;
    private boolean accept;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
