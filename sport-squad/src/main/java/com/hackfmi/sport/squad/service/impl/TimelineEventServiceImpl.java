package com.hackfmi.sport.squad.service.impl;

import java.util.Date;
import java.util.List;

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
//
//    public void addPlayerSelectionEvent(String recipientId, String message, GameDetailsDto gameDetails){
//        TimelineEvent event = new TimelineEvent();
//        event.setCreationDate(new Date(System.currentTimeMillis()));
//        event.setRecipientId(new ObjectId(recipientId));
//        event.setMessage(message);
//        event.setPendingAction(true);
//        event.setSelectPlayers(true);
//        GameDetails gameDetailsDocument = new GameDetails();
//        gameDetailsDocument.setGameId(new ObjectId(gameDetails.getGameId()));
//        gameDetailsDocument.setMatchDate(gameDetails.getMatchDate());
//        gameDetailsDocument.setPlaceUrl(gameDetails.getPlaceUrl());
//
//        event.setGameDetails(gameDetailsDocument);
//        timelineEventRepository.save(event);
//    }

    @Override
    public void addPlayerMatchInvitationEvent(String recipientId, String message, String gameId, boolean selectPlayers){
        TimelineEvent event = new TimelineEvent();
        event.setCreationDate(new Date(System.currentTimeMillis()));
        event.setRecipientId(new ObjectId(recipientId));
        event.setMessage(message);
        event.setPendingAction(true);
        event.setSelectPlayers(selectPlayers);
        event.setGameId(new ObjectId(gameId));
        timelineEventRepository.save(event);
    }
    
    public List<TimelineEventDto> getTimelineEventsForPlayer(String playerId) {
    	Date currentDate = new Date(System.currentTimeMillis());
    	return timelineEventAssembler.toDtos(timelineEventRepository.findByRecipientIdAndCreationDateLessThan(new ObjectId(playerId), currentDate));
    }
}
