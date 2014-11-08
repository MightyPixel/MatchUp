package com.hackfmi.sport.squad.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by inakov on 14-11-8.
 */
public class PlayerPosition {

    private ObjectId playerId;
    private Integer gamePosition;

    public ObjectId getPlayerId() {
        return playerId;
    }

    public void setPlayerId(ObjectId playerId) {
        this.playerId = playerId;
    }

    public Integer getGamePosition() {
        return gamePosition;
    }

    public void setGamePosition(Integer gamePosition) {
        this.gamePosition = gamePosition;
    }
}
