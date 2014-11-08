package com.hackfmi.sport.squad.repository;

import com.hackfmi.sport.squad.domain.Team;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
public interface TeamRepository extends CrudRepository<Team, ObjectId> {

    List<Team> findByNameLike(String name);
}
