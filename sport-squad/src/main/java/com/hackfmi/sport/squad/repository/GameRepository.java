package com.hackfmi.sport.squad.repository;

import com.hackfmi.sport.squad.domain.Game;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by inakov on 14-11-8.
 */
public interface GameRepository extends CrudRepository<Game, ObjectId> {
}
