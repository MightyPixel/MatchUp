package com.hackfmi.sport.squad.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackfmi.sport.squad.dto.TeamDto;
import com.hackfmi.sport.squad.service.TeamService;
import com.hackfmi.sport.squad.web.controller.command.CreateTeamCommand;

/**
 * Created by inakov on 14-11-8.
 */
@RestController
@RequestMapping("/service/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.GET, value = "/get", params = {"id"}, produces = "application/json")
    public ResponseEntity<TeamDto> getTeamById(@RequestParam String id) {
    	TeamDto team = teamService.findById(id);
    	if (team != null) {
    		return new ResponseEntity<TeamDto>(teamService.findById(id), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<TeamDto>(HttpStatus.NOT_FOUND);
    	}
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get", params = "namePattern", produces = "application/json")
    public ResponseEntity<List<TeamDto>> getTeamByNameLike(@RequestParam String name){
        return new ResponseEntity<List<TeamDto>>(teamService.findByNameLike(name), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/getMatching", params = {"id"}, produces = "application/json")
    public ResponseEntity<List<TeamDto>> getMatchingTeams(@RequestParam String id) {
    	TeamDto team = teamService.findById(id);
    	if (team != null) {
    		return new ResponseEntity<List<TeamDto>>(teamService.getMatchingTeams(team), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<List<TeamDto>>(HttpStatus.NOT_FOUND);
    	}
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = "application/json")
    public ResponseEntity<TeamDto> createTeam(@RequestBody CreateTeamCommand request){
        TeamDto team = teamService.createTeam(request);
        return new ResponseEntity<TeamDto>(team, HttpStatus.OK);
    }

}
