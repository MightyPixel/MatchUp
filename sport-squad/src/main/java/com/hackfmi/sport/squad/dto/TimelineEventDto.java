package com.hackfmi.sport.squad.dto;

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

    private boolean expiring = false;
    private Date expireOn;
    private String message;

    private GameDetailsDto gameDetails;

    private Boolean pendingAction = false;
    private Boolean accepted;
    private Boolean selectPlayers;

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

    public boolean isExpiring() {
        return expiring;
    }

    public void setExpiring(boolean expiring) {
        this.expiring = expiring;
    }

    public Date getExpireOn() {
        return expireOn;
    }

    public void setExpireOn(Date expireOn) {
        this.expireOn = expireOn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GameDetailsDto getGameDetails() {
        return gameDetails;
    }

    public void setGameDetails(GameDetailsDto gameDetails) {
        this.gameDetails = gameDetails;
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

    public Boolean getSelectPlayers() {
        return selectPlayers;
    }

    public void setSelectPlayers(Boolean selectPlayers) {
        this.selectPlayers = selectPlayers;
    }
}
