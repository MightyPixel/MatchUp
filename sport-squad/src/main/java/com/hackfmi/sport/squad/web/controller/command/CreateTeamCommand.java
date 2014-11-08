package com.hackfmi.sport.squad.web.controller.command;

import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
public class CreateTeamCommand {

    private String teamName;
    private List<String> membersIds;
    private List<Moments> schedule;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<String> getMembersIds() {
        return membersIds;
    }

    public void setMembersIds(List<String> membersIds) {
        this.membersIds = membersIds;
    }

    public List<Moments> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Moments> schedule) {
        this.schedule = schedule;
    }

}
