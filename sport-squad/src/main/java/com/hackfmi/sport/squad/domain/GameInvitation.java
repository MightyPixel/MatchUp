package com.hackfmi.sport.squad.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by inakov on 14-11-8.
 */
@Document
public class GameInvitation {

    @Id
    private ObjectId id;
    private ObjectId gameId;

    @DBRef
    private Player receiver;
    private InvitationStatus status;

}
