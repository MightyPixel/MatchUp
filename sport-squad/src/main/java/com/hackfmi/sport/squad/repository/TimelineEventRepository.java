package com.hackfmi.sport.squad.repository;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hackfmi.sport.squad.domain.TimelineEvent;

/**
 * Created by inakov on 14-11-8.
 */
public interface TimelineEventRepository extends PagingAndSortingRepository<TimelineEvent, ObjectId> {
	public List<TimelineEvent> findByRecipientIdAndCreationDateLessThan(ObjectId recipientId, Date currentDate);
}
