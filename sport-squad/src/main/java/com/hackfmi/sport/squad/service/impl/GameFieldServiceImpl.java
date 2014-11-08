package com.hackfmi.sport.squad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hackfmi.sport.squad.assembler.GameFieldAssembler;
import com.hackfmi.sport.squad.domain.GameField;
import com.hackfmi.sport.squad.dto.GameFieldDto;
import com.hackfmi.sport.squad.repository.GameFieldRepository;
import com.hackfmi.sport.squad.service.GameFieldService;

/**
 * Created by inakov on 14-11-8.
 */
@Service
public class GameFieldServiceImpl implements GameFieldService {

    @Autowired
    private GameFieldRepository gameFieldRepository;
    
	@Autowired
	private GameFieldAssembler gameFieldAssembler;
    
    @Override
    public List<GameFieldDto> getGameFieldsPage(String city, int page, int size, Sort sort) {
    	Page<GameField> gameFieldPage = gameFieldRepository.findByCity(city, new PageRequest(page, size, sort));
    	List<GameField> gameFieldList = gameFieldPage.getContent();
    	return gameFieldAssembler.toDtos(gameFieldList);
    }
}
