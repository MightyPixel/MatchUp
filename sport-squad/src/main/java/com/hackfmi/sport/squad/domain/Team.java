package com.hackfmi.sport.squad.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
@Document
public class Team {

    @Id
    private ObjectId id;

    @Indexed
    private String name;

    @DBRef
    private Player captain;
    private List<ObjectId> playersIds = new ArrayList<>();

    //TODO: add team schedule

    private Double rating = 0d;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public List<ObjectId> getPlayersIds() {
        return playersIds;
    }

    public void setPlayersIds(List<ObjectId> playersIds) {
        this.playersIds = playersIds;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
