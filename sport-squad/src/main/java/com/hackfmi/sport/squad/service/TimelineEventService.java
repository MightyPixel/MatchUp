package com.hackfmi.sport.squad.service;

import java.util.List;

import com.hackfmi.sport.squad.dto.TimelineEventDto;

/**
 * Created by inakov on 14-11-8.
 */
public interface TimelineEventService {

//    public void addGameArrangedOrChangedEvent(String recipientId, String message, GameDetailsDto gameDetails);
//    public void addPlayerSelectionEvent(String recipientId, String message, GameDetailsDto gameDetails);
    public void addPlayerMatchInvitationEvent(String recipientId, String message, String gameId, boolean selectPlayers);
    public List<TimelineEventDto> getTimelineEventsForPlayer(String playerId);
}
