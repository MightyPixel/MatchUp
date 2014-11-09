package com.hackfmi.sport.squad.domain;

/**
 * Created by inakov on 14-11-9.
 */
public class GameScore {
    private Integer challengerTeamScore;
    private Integer challengedTeamScore;

    public Integer getChallengerTeamScore() {
        return challengerTeamScore;
    }

    public void setChallengerTeamScore(Integer challengerTeamScore) {
        this.challengerTeamScore = challengerTeamScore;
    }

    public Integer getChallengedTeamScore() {
        return challengedTeamScore;
    }

    public void setChallengedTeamScore(Integer challengedTeamScore) {
        this.challengedTeamScore = challengedTeamScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameScore gameScore = (GameScore) o;

        if (challengedTeamScore != null ? !challengedTeamScore.equals(gameScore.challengedTeamScore) : gameScore.challengedTeamScore != null)
            return false;
        if (challengerTeamScore != null ? !challengerTeamScore.equals(gameScore.challengerTeamScore) : gameScore.challengerTeamScore != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = challengerTeamScore != null ? challengerTeamScore.hashCode() : 0;
        result = 31 * result + (challengedTeamScore != null ? challengedTeamScore.hashCode() : 0);
        return result;
    }
}
