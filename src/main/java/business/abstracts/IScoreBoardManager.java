package business.abstracts;

import java.util.List;

import entities.concretes.LiveMatch;
import entities.concretes.Match;

public interface IScoreBoardManager {
    boolean startGame(Match match);
    boolean finishGame(Match match);
    boolean updateScore(LiveMatch liveMatch);
    boolean increaseScoreByTeamName(String teamName);
    List<LiveMatch> getSummary();
}
