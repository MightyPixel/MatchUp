package com.hackfmi.sport.squad.repository;

import com.hackfmi.sport.squad.domain.TimelineEvent;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by inakov on 14-11-8.
 */
public interface TimelineEventRepository extends PagingAndSortingRepository<TimelineEvent, ObjectId> {
}
