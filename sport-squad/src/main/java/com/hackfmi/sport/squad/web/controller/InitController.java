package com.hackfmi.sport.squad.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackfmi.sport.squad.domain.EventType;
import com.hackfmi.sport.squad.domain.Player;
import com.hackfmi.sport.squad.domain.ScheduleInterval;
import com.hackfmi.sport.squad.domain.Team;
import com.hackfmi.sport.squad.domain.TimelineEvent;
import com.hackfmi.sport.squad.repository.PlayerRepository;
import com.hackfmi.sport.squad.repository.TeamRepository;
import com.hackfmi.sport.squad.repository.TimelineEventRepository;

@RestController
@RequestMapping("/service/init")
public class InitController {
	
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TimelineEventRepository timelineEventRepository;
	
    Player ivan = new Player();
    Player ognyan = new Player();
    Player andreya = new Player();
    Player adriana = new Player();

    Team leet = new Team();
    Team opponent = new Team();
    
    TimelineEvent timelineEvent = new TimelineEvent();

    @RequestMapping(method = RequestMethod.GET, value = "/player")
    public void initPlayers() {
    	
		ivan.setAge(21);
		ivan.setCity("Sofia");
		ivan.setEmail("ivan.nakov@gmail.com");
		ivan.setId(new ObjectId());
		ivan.setName("Ivan Nakov");
		ivan.setPassword("pass");
		
		ognyan.setAge(21);
		ognyan.setCity("Sofia");
		ognyan.setEmail("ognyan.angelov@gmail.com");
		ognyan.setId(new ObjectId());
		ognyan.setName("Ognyan Angelov");
		ognyan.setPassword("pass");
		
		andreya.setAge(21);
		andreya.setCity("Sofia");
		andreya.setEmail("andreya.kostov@gmail.com");
		andreya.setId(new ObjectId());
		andreya.setName("Andreya Kostov");
		andreya.setPassword("pass");
		
		adriana.setAge(20);
		adriana.setCity("Sofia");
		adriana.setEmail("adriana.stefanova@gmail.com");
		adriana.setId(new ObjectId());
		adriana.setName("Adriana Stefanova");
		adriana.setPassword("pass");
		
		playerRepository.save(ivan);
		playerRepository.save(ognyan);
		playerRepository.save(andreya);
		playerRepository.save(adriana);
    	
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/team")
    public void initTeams() {
    	leet.setId(new ObjectId());
    	leet.setCaptain(ognyan);
    	leet.setCity("Sofia");
    	leet.setName("1337");
    	List <ObjectId> list = Arrays.asList(andreya.getId(), ognyan.getId(), adriana.getId(), ivan.getId());
    	leet.setPlayersIds(list);
    	leet.setRating(12d);
    	leet.setSchedule(new ArrayList<ScheduleInterval>());
    	
		teamRepository.save(leet);
		
		leet.setName("2337");
		leet.setId(new ObjectId());
		leet.setRating(8d);
		
		teamRepository.save(leet);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/event")
    public void initTimelineEvents() {
		timelineEvent.setId(new ObjectId());
		timelineEvent.setRecipientId(new ObjectId("545f8a10120d2ccbb4352308"));
		timelineEvent.setCreationDate(new Date(System.currentTimeMillis() - 10000000L));
		timelineEvent.setChallengedTeamName("TUES");
		timelineEvent.setAccepted(false);
		timelineEvent.setChallengerTeamName("1337");
		timelineEvent.setGameId(new ObjectId());
		timelineEvent.setMessage("play with us!");
		timelineEvent.setPendingAction(Boolean.TRUE);
		timelineEvent.setStatus(EventType.INVITED);

		timelineEventRepository.save(timelineEvent);
    }


}
