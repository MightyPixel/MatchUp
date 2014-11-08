package com.hackfmi.sport.squad.repository;

import com.hackfmi.sport.squad.domain.Player;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;

import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
@Repository
public class PlayerRepositoryImpl implements PlayerRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Player findByEmail(String email) {
        System.out.println("email:" + email);
        Query query = query(where("email").is(email));
        return mongoTemplate.findOne(query, Player.class);
    }

}
