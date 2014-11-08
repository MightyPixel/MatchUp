package com.hackfmi.sport.squad.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
@Document
public class Game {

    @Id
    private ObjectId id;
    private GameType type;
    private Sport sport;
    private GameState state;

    private Timestamp startDate;
    private Timestamp creationDate;

    private List<PlayerPosition> playersPositions;

    @DBRef
    private GameField gameField;

    @DBRef
    private List<Team> teams;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<PlayerPosition> getPlayersPositions() {
        return playersPositions;
    }

    public void setPlayersPositions(List<PlayerPosition> playersPositions) {
        this.playersPositions = playersPositions;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
