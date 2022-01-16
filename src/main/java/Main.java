import business.concretes.ScoreBoardManager;
import entities.concretes.LiveMatch;
import entities.concretes.Match;
import entities.concretes.ScoreBoard;

public class Main {
    public static void main(String[] args) {
        ScoreBoardManager scoreBoardManager = new ScoreBoardManager(new ScoreBoard());
        scoreBoardManager.startGame(new Match("Mexico", "Canada"));
        scoreBoardManager.startGame(new Match("Spain", "Brazil"));
        scoreBoardManager.startGame(new Match("Germany", "France"));
        scoreBoardManager.startGame(new Match("Uruguay", "Italy"));
        scoreBoardManager.startGame(new Match("Argentina", "Australia"));

        scoreBoardManager.updateScore(new LiveMatch("Mexico", 0, "Canada", 5));
        scoreBoardManager.updateScore(new LiveMatch("Spain", 10,"Brazil", 2));
        scoreBoardManager.updateScore(new LiveMatch("Germany", 2, "France", 2));
        scoreBoardManager.updateScore(new LiveMatch("Uruguay", 6, "Italy", 6));
        scoreBoardManager.updateScore(new LiveMatch("Argentina", 3, "Australia", 1));


        System.out.println("LIVE SCORES");
        for (LiveMatch m: scoreBoardManager.getSummary()) {
            System.out.println(m.getMatchSummary());
        }

        scoreBoardManager.finishGame(new Match("Mexico", "Canada"));
        scoreBoardManager.increaseScoreByTeamName("Argentina");


        System.out.println("LIVE SCORES");
        for (LiveMatch m: scoreBoardManager.getSummary()) {
            System.out.println(m.getMatchSummary());
        }
    }
}
