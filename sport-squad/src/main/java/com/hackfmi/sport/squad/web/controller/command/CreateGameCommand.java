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

    private String challengerTeam;
    private String challengedTeam;
    private Timestamp startDate;
    private String gameFieldId;

    public String getChallengerTeam() {
        return challengerTeam;
    }

    public void setChallengerTeam(String challengerTeam) {
        this.challengerTeam = challengerTeam;
    }

    public String getChallengedTeam() {
        return challengedTeam;
    }

    public void setChallengedTeam(String challengedTeam) {
        this.challengedTeam = challengedTeam;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public String getGameFieldId() {
        return gameFieldId;
    }

    public void setGameFieldId(String gameFieldId) {
        this.gameFieldId = gameFieldId;
    }
}
