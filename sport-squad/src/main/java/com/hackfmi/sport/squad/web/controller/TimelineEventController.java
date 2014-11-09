package com.hackfmi.sport.squad.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackfmi.sport.squad.dto.TimelineEventDto;
import com.hackfmi.sport.squad.service.TimelineEventService;

@RestController
@RequestMapping("/service/timeline")
public class TimelineEventController {
	
	@Autowired
	private TimelineEventService timelineEventService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/find", params = {"playerId"}, produces = "application/json")
	public ResponseEntity<List<TimelineEventDto>> getTimelineEventsForPlayer(@RequestParam String playerId) {
		return new ResponseEntity<List<TimelineEventDto>>(timelineEventService.getTimelineEventsForPlayer(playerId), HttpStatus.OK);
	}

}
