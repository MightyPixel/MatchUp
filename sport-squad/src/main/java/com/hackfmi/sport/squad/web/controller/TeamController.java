package com.hackfmi.sport.squad.web.controller;

import com.hackfmi.sport.squad.domain.Team;
import com.hackfmi.sport.squad.service.TeamService;
import com.hackfmi.sport.squad.web.controller.request.CreateTeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by inakov on 14-11-8.
 */
@RestController
@RequestMapping("/service/team")
public class TeamController {

    @Autowired
    private TeamService teamService;


    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes =    "application/json", produces = "application/json")
    public ResponseEntity<Team> createTeam(@RequestBody CreateTeamRequest request){
        System.out.println();
        return null;
    }

}
