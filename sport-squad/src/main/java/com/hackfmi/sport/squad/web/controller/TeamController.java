package com.hackfmi.sport.squad.web.controller;

import com.hackfmi.sport.squad.domain.Team;
import com.hackfmi.sport.squad.service.TeamService;
import com.hackfmi.sport.squad.web.controller.command.CreateTeamCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
@RestController
@RequestMapping("/service/team")
public class TeamController {

    @Autowired
    private TeamService teamService;


    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = "application/json")
    public ResponseEntity<Team> createTeam(@RequestBody CreateTeamCommand request){
        Team team = teamService.createTeam(request);
        return new ResponseEntity<Team>(team, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}", consumes = "application/json")
    public ResponseEntity<List<Team>> createTeam(@PathVariable String name){
        List<Team> teams = teamService.getTeamsByNameLike(name);

        return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
    }

}
