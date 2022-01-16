package business.concretes;

import java.util.ArrayList;
import java.util.List;

import business.abstracts.IScoreBoardManager;
import entities.concretes.LiveMatch;
import entities.concretes.ScoreBoard;
import entities.concretes.Match;

public class ScoreBoardManager implements IScoreBoardManager {
    private final ScoreBoard scoreBoard;

    public ScoreBoardManager(ScoreBoard scoreBoard) {
        super();
        this.scoreBoard = scoreBoard;
    }

    public boolean startGame(Match match) {
        if (checkTeamsAlreadyInMatch(match)) {
            return false;
        }
        scoreBoard.getLiveMatchList().add(new LiveMatch(match.getHomeTeam(), match.getAwayTeam()));
        return true;
    }

    private boolean checkTeamsAlreadyInMatch(Match match) {
        for(LiveMatch m : scoreBoard.getLiveMatchList()) {
            if(m.getHomeTeam().equals(match.getHomeTeam()) || m.getAwayTeam().equals(match.getAwayTeam())) {
                return true;
            }
        }
        return false;
    }

    public boolean finishGame(Match match) {
        List<LiveMatch> liveMatchList = scoreBoard.getLiveMatchList();
        for(LiveMatch m : liveMatchList) {
            if(m.getHomeTeam().equals(match.getHomeTeam()) && m.getAwayTeam().equals(match.getAwayTeam())) {
                liveMatchList.remove(m);
                return true;
            }
        }
        return false;
    }

    public boolean updateScore(LiveMatch liveMatch) {
        List<LiveMatch> liveMatchList = scoreBoard.getLiveMatchList();
        for(int i = 0; i < liveMatchList.size(); i++) {
            if(liveMatchList.get(i).getHomeTeam().equals(liveMatch.getHomeTeam())
                    && liveMatchList.get(i).getAwayTeam().equals(liveMatch.getAwayTeam())) {
                liveMatchList.set(i, liveMatch);
                return true;
            }
        }
        return false;
    }

    public boolean increaseScoreByTeamName(String teamName) {
        List<LiveMatch> liveMatchList = scoreBoard.getLiveMatchList();
        for(LiveMatch m : liveMatchList) {
            if(m.getHomeTeam().equals(teamName)) {
                m.setHomeScore(m.getHomeScore() + 1);
                return true;
            }
            else if(m.getAwayTeam().equals(teamName)) {
                m.setAwayScore(m.getAwayScore() + 1);
                return true;
            }
        }
        return false;
    }

    public List<LiveMatch> getSummary() {
        List<LiveMatch> matchListCopy = new ArrayList<>(scoreBoard.getLiveMatchList());
        matchListCopy.sort((o1, o2) -> {
            if (o1.getTotalScore() < o2.getTotalScore()) {
                return 1;
            }
            return -1;
        });
        return matchListCopy;
    }

}
