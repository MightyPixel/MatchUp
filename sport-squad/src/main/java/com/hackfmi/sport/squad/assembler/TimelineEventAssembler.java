package com.hackfmi.sport.squad.assembler;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.hackfmi.sport.squad.domain.TimelineEvent;
import com.hackfmi.sport.squad.dto.TimelineEventDto;

/**
 * Created by inakov on 14-11-9.
 */
@Component
public class TimelineEventAssembler extends BaseAssembler<TimelineEvent, TimelineEventDto> {
    @Override
    protected TimelineEvent createDocument() {
        return new TimelineEvent();
    }

    @Override
    protected TimelineEventDto createDto() {
        return new TimelineEventDto();
    }

    @Override
    protected void convertToDto(TimelineEvent timelineEvent, TimelineEventDto timelineEventDto) {
        timelineEventDto.setAccepted(timelineEvent.getAccepted());
        timelineEventDto.setCreationDate(timelineEvent.getCreationDate());
        timelineEventDto.setExpireOn(timelineEvent.getExpireOn());
        timelineEventDto.setExpiring(timelineEvent.isExpiring());

        timelineEventDto.setGameId(timelineEvent.getGameId().toString());
        
        timelineEventDto.setId(timelineEvent.getId().toString());
        timelineEventDto.setMessage(timelineEvent.getMessage());
        timelineEventDto.setPendingAction(timelineEvent.getPendingAction());
        timelineEventDto.setRecipientId(timelineEvent.getRecipientId().toString());
        timelineEventDto.setSelectPlayers(timelineEvent.getSelectPlayers());
    }

    @Override
    protected void convertToDocument(TimelineEvent timelineEvent, TimelineEventDto timelineEventDto) {
        timelineEvent.setAccepted(timelineEventDto.getAccepted());
        timelineEvent.setCreationDate(timelineEventDto.getCreationDate());
        timelineEvent.setExpireOn(timelineEventDto.getExpireOn());
        timelineEvent.setExpiring(timelineEventDto.isExpiring());

        timelineEvent.setGameId(new ObjectId(timelineEventDto.getGameId()));

        timelineEvent.setId(new ObjectId(timelineEventDto.getId()));
        timelineEvent.setMessage(timelineEventDto.getMessage());
        timelineEvent.setPendingAction(timelineEventDto.getPendingAction());
        timelineEvent.setRecipientId(new ObjectId(timelineEventDto.getRecipientId()));
        timelineEvent.setSelectPlayers(timelineEventDto.getSelectPlayers());

    }
}
