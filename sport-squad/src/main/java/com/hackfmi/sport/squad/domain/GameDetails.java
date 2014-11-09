package com.hackfmi.sport.squad.domain;

import org.bson.types.ObjectId;

import java.util.Date;

/**
 * Created by inakov on 14-11-9.
 */
public class GameDetails {
    private String placeUrl;
    private Date matchDate;
    private ObjectId gameId;

    public String getPlaceUrl() {
        return placeUrl;
    }

    public void setPlaceUrl(String placeUrl) {
        this.placeUrl = placeUrl;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public ObjectId getGameId() {
        return gameId;
    }

    public void setGameId(ObjectId gameId) {
        this.gameId = gameId;
    }
}
