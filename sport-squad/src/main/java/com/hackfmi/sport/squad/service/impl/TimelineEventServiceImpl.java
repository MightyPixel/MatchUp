package com.hackfmi.sport.squad.service.impl;

import java.util.Date;
import java.util.List;

import com.hackfmi.sport.squad.domain.EventType;
import com.hackfmi.sport.squad.web.controller.command.CaptainDecisionCommand;
import com.hackfmi.sport.squad.web.controller.command.InvitationDecisionCommand;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfmi.sport.squad.assembler.TimelineEventAssembler;
import com.hackfmi.sport.squad.domain.TimelineEvent;
import com.hackfmi.sport.squad.dto.TimelineEventDto;
import com.hackfmi.sport.squad.repository.TimelineEventRepository;
import com.hackfmi.sport.squad.service.TimelineEventService;

/**
 * Created by inakov on 14-11-8.
 */
@Service
public class TimelineEventServiceImpl implements TimelineEventService {

    @Autowired
    private TimelineEventRepository timelineEventRepository;
    
    @Autowired
    private TimelineEventAssembler timelineEventAssembler;

//    public void addGameArrangedOrChangedEvent(String recipientId, String message, GameDetailsDto gameDetails){
//        TimelineEvent event = new TimelineEvent();
//        event.setCreationDate(new Date(System.currentTimeMillis()));
//        event.setRecipientId(new ObjectId(recipientId));
//        event.setMessage(message);
//        event.setPendingAction(false);
//        event.setSelectPlayers(false);
//        GameDetails gameDetailsDocument = new GameDetails();
//        gameDetailsDocument.setGameId(new ObjectId(gameDetails.getGameId()));
//        gameDetailsDocument.setMatchDate(gameDetails.getMatchDate());
//        gameDetailsDocument.setPlaceUrl(gameDetails.getPlaceUrl());
//
//        event.setGameDetails(gameDetailsDocument);
//        timelineEventRepository.save(event);
//    }


    @Override
    public void addPlayerMatchInvitationEvent(String recipientId, String message, String gameId, boolean selectPlayers,
                                              String challengedTeamName, String challengerTeamName){
        TimelineEvent event = new TimelineEvent();
        event.setCreationDate(new Date(System.currentTimeMillis()));
        event.setRecipientId(new ObjectId(recipientId));
        event.setMessage(message);
        event.setPendingAction(true);
        event.setChallengedTeamName(challengedTeamName);
        event.setChallengerTeamName(challengerTeamName);
        event.setStatus(EventType.INVITED);
        event.setGameId(new ObjectId(gameId));

        timelineEventRepository.save(event);
    }

    @Override
    public void addGameChangedEvent(String recipientId, String message, String gameId, boolean selectPlayers,
                                   String challengedTeamName, String challengerTeamName){
        TimelineEvent event = new TimelineEvent();
        event.setCreationDate(new Date(System.currentTimeMillis()));
        event.setRecipientId(new ObjectId(recipientId));
        event.setMessage(message);
        event.setPendingAction(false);
        event.setChallengedTeamName(challengedTeamName);
        event.setChallengerTeamName(challengerTeamName);
        event.setStatus(EventType.GAME_CHANGE);
        event.setGameId(new ObjectId(gameId));

        timelineEventRepository.save(event);
    }

    @Override
    public void addEnterScoreEvent(String recipientId, String message, String gameId, boolean selectPlayers,
                                              String challengedTeamName, String challengerTeamName, Date gameDate){
        TimelineEvent event = new TimelineEvent();
        event.setCreationDate(gameDate);
        event.setRecipientId(new ObjectId(recipientId));
        event.setMessage(message);
        event.setPendingAction(true);
        event.setChallengedTeamName(challengedTeamName);
        event.setChallengerTeamName(challengerTeamName);
        event.setStatus(EventType.SCORE);
        event.setGameId(new ObjectId(gameId));

        timelineEventRepository.save(event);
    }
    
    public List<TimelineEventDto> getTimelineEventsForPlayer(String playerId) {
    	Date currentDate = new Date(System.currentTimeMillis());
    	return timelineEventAssembler.toDtos(timelineEventRepository.findByRecipientIdAndCreationDateLessThan(new ObjectId(playerId), currentDate));
    }

    @Override
    public TimelineEventDto processGameInvitation(InvitationDecisionCommand command) {
        TimelineEvent event = timelineEventRepository.findOne(new ObjectId(command.getEventId()));
        event.setAccepted(command.isAccept());
        event.setPendingAction(false);
        timelineEventRepository.save(event);

        return timelineEventAssembler.toDto(event);
    }

    @Override
    public TimelineEventDto processCaptainDecision(CaptainDecisionCommand command) {
        TimelineEvent event = timelineEventRepository.findOne(new ObjectId(command.getEventId()));
        if(command.getAccept() != null){
            event.setAccepted(command.getAccept());
            event.setPendingAction(false);
            timelineEventRepository.save(event);
        }

        return timelineEventAssembler.toDto(event);
    }
}
