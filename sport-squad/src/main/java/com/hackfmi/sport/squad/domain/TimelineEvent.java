package com.hackfmi.sport.squad.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by inakov on 14-11-8.
 */
@Document
public class TimelineEvent implements BaseDocument {
    @Id
    private ObjectId id;
    @Indexed
    private ObjectId recipientId;
    private Date creationDate;

    private String challengedTeamName;
    private String challengerTeamName;
    private EventType status;
    //private boolean expiring = false;
    //private Date expireOn;
    private String message;

    private ObjectId gameId;

    private Boolean pendingAction = false;
    private Boolean accepted;
    //private Boolean selectPlayers;

    @Override
    public ObjectId getId() {
        return id;
    }

    @Override
    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(ObjectId recipientId) {
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

    public ObjectId getGameId() {
        return gameId;
    }

    public void setGameId(ObjectId gameId) {
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