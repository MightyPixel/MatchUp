package com.hackfmi.sport.squad.domain;

import com.hackfmi.sport.squad.dto.PlayerPositionDto;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
@Document
public class Game {

    @Id
    private ObjectId id;
    private GameType type = GameType.RANKED;
    private Sport sport = Sport.FOOTBALL;
    private GameState state = GameState.NEGOTIATION;

    private Timestamp startDate;
    private Timestamp creationDate;

    private List<PlayerPosition> challengerTeamPositions;
    private List<PlayerPosition> challengedTeamPositions;
    private List<GameInvitation> gameInvitationsForChallengerTeam = new ArrayList<>();
    private List<GameInvitation> gameInvitationsForChallengedTeam = new ArrayList<>();

    private GameScore gameScore;

    private GameScore challengerTeamScoreDeclared;
    private GameScore challengedTeamScoreDeclared;

    @DBRef
    private GameField gameField;

    @DBRef
    private Team challengerTeam;
    @DBRef
    private Team challengedTeam;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public Team getChallengedTeam() {
        return challengedTeam;
    }

    public void setChallengedTeam(Team challengedTeam) {
        this.challengedTeam = challengedTeam;
    }

    public Team getChallengerTeam() {

        return challengerTeam;
    }

    public void setChallengerTeam(Team challengerTeam) {
        this.challengerTeam = challengerTeam;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public List<GameInvitation> getGameInvitationsForChallengerTeam() {
        return gameInvitationsForChallengerTeam;
    }

    public void setGameInvitationsForChallengerTeam(List<GameInvitation> gameInvitationsForChallengerTeam) {
        this.gameInvitationsForChallengerTeam = gameInvitationsForChallengerTeam;
    }

    public List<GameInvitation> getGameInvitationsForChallengedTeam() {
        return gameInvitationsForChallengedTeam;
    }

    public void setGameInvitationsForChallengedTeam(List<GameInvitation> gameInvitationsForChallengedTeam) {
        this.gameInvitationsForChallengedTeam = gameInvitationsForChallengedTeam;
    }

    public List<PlayerPosition> getChallengedTeamPositions() {
        return challengedTeamPositions;
    }

    public void setChallengedTeamPositions(List<PlayerPosition> challengedTeamPositions) {
        this.challengedTeamPositions = challengedTeamPositions;
    }

    public List<PlayerPosition> getChallengerTeamPositions() {
        return challengerTeamPositions;
    }

    public void setChallengerTeamPositions(List<PlayerPosition> challengerTeamPositions) {
        this.challengerTeamPositions = challengerTeamPositions;
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public void setGameScore(GameScore gameScore) {
        this.gameScore = gameScore;
    }

    public GameScore getChallengedTeamScoreDeclared() {
        return challengedTeamScoreDeclared;
    }

    public void setChallengedTeamScoreDeclared(GameScore challengedTeamScoreDeclared) {
        this.challengedTeamScoreDeclared = challengedTeamScoreDeclared;
    }

    public GameScore getChallengerTeamScoreDeclared() {
        return challengerTeamScoreDeclared;
    }

    public void setChallengerTeamScoreDeclared(GameScore challengerTeamScoreDeclared) {
        this.challengerTeamScoreDeclared = challengerTeamScoreDeclared;
    }
}
