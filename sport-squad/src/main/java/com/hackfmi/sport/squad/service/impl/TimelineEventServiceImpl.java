package com.hackfmi.sport.squad.service.impl;

import com.hackfmi.sport.squad.domain.GameDetails;
import com.hackfmi.sport.squad.domain.TimelineEvent;
import com.hackfmi.sport.squad.dto.GameDetailsDto;
import com.hackfmi.sport.squad.repository.TimelineEventRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by inakov on 14-11-8.
 */
@Service
public class TimelineEventServiceImpl {

    @Autowired
    private TimelineEventRepository timelineEventRepository;


    public void addGameArrangedOrChangedEvent(String recipientId, String message, GameDetailsDto gameDetails){
        TimelineEvent event = new TimelineEvent();
        event.setCreationDate(new Date(System.currentTimeMillis()));
        event.setRecipientId(new ObjectId(recipientId));
        event.setMessage(message);
        event.setPendingAction(false);
        event.setSelectPlayers(false);
        GameDetails gameDetailsDocument = new GameDetails();
        gameDetailsDocument.setGameId(new ObjectId(gameDetails.getGameId()));
        gameDetailsDocument.setMatchDate(gameDetails.getMatchDate());
        gameDetailsDocument.setPlaceUrl(gameDetails.getPlaceUrl());

        event.setGameDetails(gameDetailsDocument);
        timelineEventRepository.save(event);
    }

    public void addPlayerSelectionEvent(String recipientId, String message, GameDetailsDto gameDetails){
        TimelineEvent event = new TimelineEvent();
        event.setCreationDate(new Date(System.currentTimeMillis()));
        event.setRecipientId(new ObjectId(recipientId));
        event.setMessage(message);
        event.setPendingAction(true);
        event.setSelectPlayers(true);
        GameDetails gameDetailsDocument = new GameDetails();
        gameDetailsDocument.setGameId(new ObjectId(gameDetails.getGameId()));
        gameDetailsDocument.setMatchDate(gameDetails.getMatchDate());
        gameDetailsDocument.setPlaceUrl(gameDetails.getPlaceUrl());

        event.setGameDetails(gameDetailsDocument);
        timelineEventRepository.save(event);
    }

    public void addMatchInvitationEvent(String recipientId, String message, GameDetailsDto gameDetails){
        TimelineEvent event = new TimelineEvent();
        event.setCreationDate(new Date(System.currentTimeMillis()));
        event.setRecipientId(new ObjectId(recipientId));
        event.setMessage(message);
        event.setPendingAction(true);
        event.setSelectPlayers(false);
        GameDetails gamedetailsDocument = new GameDetails();
        gamedetailsDocument.setGameId(new ObjectId(gameDetails.getGameId()));
        gamedetailsDocument.setMatchDate(gameDetails.getMatchDate());
        gamedetailsDocument.setPlaceUrl(gameDetails.getPlaceUrl());

        event.setGameDetails(gamedetailsDocument);
        timelineEventRepository.save(event);
    }
}
