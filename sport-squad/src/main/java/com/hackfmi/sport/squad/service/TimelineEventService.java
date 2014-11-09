package com.hackfmi.sport.squad.service;

import java.util.Date;
import java.util.List;

import com.hackfmi.sport.squad.dto.TimelineEventDto;
import com.hackfmi.sport.squad.web.controller.command.CaptainDecisionCommand;
import com.hackfmi.sport.squad.web.controller.command.InvitationDecisionCommand;

/**
 * Created by inakov on 14-11-8.
 */
public interface TimelineEventService {

    public void addPlayerMatchInvitationEvent(String recipientId, String message, String gameId, boolean selectPlayers,
                                              String challengedTeamName, String challengerTeamName);
    public void addGameChangedEvent(String recipientId, String message, String gameId, boolean selectPlayers,
                                    String challengedTeamName, String challengerTeamName);
    public void addEnterScoreEvent(String recipientId, String message, String gameId, boolean selectPlayers,
                                   String challengedTeamName, String challengerTeamName, Date gameDate);

    public List<TimelineEventDto> getTimelineEventsForPlayer(String playerId);

    public TimelineEventDto processGameInvitation(InvitationDecisionCommand command);
    public TimelineEventDto processCaptainDecision(CaptainDecisionCommand command);
}
