package com.hackfmi.sport.squad.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.hackfmi.sport.squad.domain.Player;

/**
 * Created by inakov on 14-11-8.
 */
public interface PlayerRepository extends CrudRepository<Player, ObjectId> {
    public List<Player> findByNameLike(String namePattern);
}
