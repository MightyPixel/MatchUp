package com.hackfmi.sport.squad.repository;

import com.hackfmi.sport.squad.domain.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by inakov on 14-11-8.
 */
public interface PlayerRepository {
    Player findByEmail(String email);
}
