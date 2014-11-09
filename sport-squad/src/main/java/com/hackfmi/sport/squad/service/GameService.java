package com.hackfmi.sport.squad.service;

import com.hackfmi.sport.squad.dto.GameDto;
import com.hackfmi.sport.squad.dto.TimelineEventDto;
import com.hackfmi.sport.squad.web.controller.command.CaptainDecisionCommand;
import com.hackfmi.sport.squad.web.controller.command.CreateGameCommand;
import com.hackfmi.sport.squad.web.controller.command.DeclareScoreCommand;
import com.hackfmi.sport.squad.web.controller.command.InvitationDecisionCommand;

/**
 * Created by inakov on 14-11-8.
 */
public interface GameService {

    public GameDto findById(String id);
    public GameDto createGame(CreateGameCommand createGameCommand);
    public TimelineEventDto handleInvitationDecisionCommand(InvitationDecisionCommand command, String playerId);
    public TimelineEventDto handleCaptainDecisionCommand(CaptainDecisionCommand command, String playerId);
    public TimelineEventDto handleDeclareScoreCommand(DeclareScoreCommand declareScoreCommand, String playerId);
}
