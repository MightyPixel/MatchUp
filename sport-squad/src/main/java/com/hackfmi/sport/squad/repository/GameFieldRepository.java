package com.hackfmi.sport.squad.repository;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hackfmi.sport.squad.domain.GameField;

/**
 * Created by inakov on 14-11-8.
 */
public interface GameFieldRepository extends PagingAndSortingRepository<GameField, ObjectId> {
	public Page<GameField> findByCity(String city, Pageable pageable);
}
