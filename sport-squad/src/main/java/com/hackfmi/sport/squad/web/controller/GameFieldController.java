package com.hackfmi.sport.squad.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackfmi.sport.squad.domain.GameField;
import com.hackfmi.sport.squad.dto.GameFieldDto;
import com.hackfmi.sport.squad.service.GameFieldService;

/**
 * Created by inakov on 14-11-8.
 */
@RestController
@RequestMapping("/service/fields")
public class GameFieldController {

    @Autowired
    private GameFieldService gameFieldService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/get", params = {"city", "page"})
    public List<GameFieldDto> getGameFieldsPage(@RequestParam String city, @RequestParam int page) {
    	List<GameFieldDto> pageOfGameFields = gameFieldService.getGameFieldsPage(city, page, 5, new Sort(Direction.DESC, "rating"));
    	return pageOfGameFields;
    }
}
