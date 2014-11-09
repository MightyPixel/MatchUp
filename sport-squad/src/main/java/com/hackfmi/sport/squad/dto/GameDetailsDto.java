package com.hackfmi.sport.squad.dto;


import java.util.Date;

/**
 * Created by inakov on 14-11-9.
 */
public class GameDetailsDto {
    private String placeUrl;
    private Date matchDate;
    private String gameId;

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

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
