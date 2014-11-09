package com.hackfmi.sport.squad.web.controller.command;

import com.hackfmi.sport.squad.domain.GameScore;

/**
 * Created by inakov on 14-11-9.
 */
public class DeclareScoreCommand {

    private String gameId;
    private GameScore gameScore;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public void setGameScore(GameScore gameScore) {
        this.gameScore = gameScore;
    }
}
