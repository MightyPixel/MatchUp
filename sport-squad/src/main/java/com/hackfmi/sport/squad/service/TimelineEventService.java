package com.hackfmi.sport.squad.service;

import com.hackfmi.sport.squad.dto.GameDetailsDto;

/**
 * Created by inakov on 14-11-8.
 */
public interface TimelineEventService {

//    public void addGameArrangedOrChangedEvent(String recipientId, String message, GameDetailsDto gameDetails);
//    public void addPlayerSelectionEvent(String recipientId, String message, GameDetailsDto gameDetails);
    public void addPlayerMatchInvitationEvent(String recipientId, String message, String gameId, boolean selectPlayers);
}
