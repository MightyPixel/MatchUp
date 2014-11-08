package com.hackfmi.sport.squad.repository;

import java.util.List;

import com.hackfmi.sport.squad.domain.Player;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by inakov on 14-11-8.
 */
public interface PlayerRepository extends CrudRepository<Player, ObjectId> {
    Player findByEmail(String email);
    public List<Player> findByNameLike(String namePattern);
}
