package com.hackfmi.sport.squad.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.hackfmi.sport.squad.dto.GameFieldDto;

/**
 * Created by inakov on 14-11-8.
 */
public interface GameFieldService {
	public List<GameFieldDto> getGameFieldsPage(String city, int page, int size, Sort sort);
}
