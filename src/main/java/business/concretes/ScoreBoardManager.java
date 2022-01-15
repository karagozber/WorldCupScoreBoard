package business.concretes;

import business.abstracts.IScoreBoardManager;
import entities.concretes.LiveMatch;
import entities.concretes.Match;

import java.util.List;

public class ScoreBoardManager implements IScoreBoardManager {
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
