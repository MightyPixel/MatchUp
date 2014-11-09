package com.hackfmi.sport.squad.dto;

import com.hackfmi.sport.squad.domain.EventType;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

/**
 * Created by inakov on 14-11-8.
 */
public class TimelineEventDto implements BaseDto {

    private String id;
    private String recipientId;
    private Date creationDate;

//    private boolean expiring = false;
//    private Date expireOn;
    private String message;
    private String challengedTeamName;
    private String challengerTeamName;
    private EventType status;

    private String gameId;
//    private GameDetailsDto gameDetails;

    private Boolean pendingAction = false;
    private Boolean accepted;
//    private Boolean selectPlayers;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getPendingAction() {
        return pendingAction;
    }

    public void setPendingAction(Boolean pendingAction) {
        this.pendingAction = pendingAction;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getChallengedTeamName() {
        return challengedTeamName;
    }

    public void setChallengedTeamName(String challengedTeamName) {
        this.challengedTeamName = challengedTeamName;
    }

    public String getChallengerTeamName() {
        return challengerTeamName;
    }

    public void setChallengerTeamName(String challengerTeamName) {
        this.challengerTeamName = challengerTeamName;
    }

    public EventType getStatus() {
        return status;
    }

    public void setStatus(EventType status) {
        this.status = status;
    }
}
