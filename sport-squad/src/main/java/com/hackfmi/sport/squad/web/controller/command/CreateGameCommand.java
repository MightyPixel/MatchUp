package com.hackfmi.sport.squad.web.controller.command;

import com.hackfmi.sport.squad.domain.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
public class CreateGameCommand {

    private GameType type;
    private Sport sport;

    private Timestamp startDate;

    private List<PlayerPosition> playersPositions;

    private ObjectId gameFieldId;

    private List<ObjectId> teamsIds;

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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public List<PlayerPosition> getPlayersPositions() {
        return playersPositions;
    }

    public void setPlayersPositions(List<PlayerPosition> playersPositions) {
        this.playersPositions = playersPositions;
    }

    public ObjectId getGameFieldId() {
        return gameFieldId;
    }

    public void setGameFieldId(ObjectId gameFieldId) {
        this.gameFieldId = gameFieldId;
    }

    public List<ObjectId> getTeamsIds() {
        return teamsIds;
    }

    public void setTeamsIds(List<ObjectId> teamsIds) {
        this.teamsIds = teamsIds;
    }
}
