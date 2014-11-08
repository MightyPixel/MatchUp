package com.hackfmi.sport.squad.domain;

import org.bson.types.ObjectId;

/**
 * Created by inakov on 14-11-8.
 */
public interface BaseDocument {

    public ObjectId getId();

    public void setId(ObjectId id);
}
