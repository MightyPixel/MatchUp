package com.hackfmi.sport.squad.repository;

import com.hackfmi.sport.squad.domain.GameField;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by inakov on 14-11-8.
 */
public interface GameFieldRepository extends CrudRepository<GameField, ObjectId> {
}
