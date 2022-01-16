package business.concretes;

import business.abstracts.IScoreBoardManager;
import entities.concretes.LiveMatch;
import entities.concretes.Match;
import entities.concretes.ScoreBoard;

import java.util.List;

public class ScoreBoardManager implements IScoreBoardManager {
    protected final ScoreBoard scoreBoard;

    public ScoreBoardManager(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public boolean startGame(Match match) {
        return false;
    }

    public boolean finishGame(Match match) {
        return false;
    }

    public boolean updateScore(LiveMatch liveMatch) {
        return false;
    }

    public boolean increaseScoreByTeamName(String teamName) {
        return false;
    }

    public List<LiveMatch> getSummary() {
        return null;
    }

}
