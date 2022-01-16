package business.concretes;

import entities.concretes.LiveMatch;
import entities.concretes.Match;
import entities.concretes.ScoreBoard;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class ScoreBoardManagerTest extends TestCase {

    private ScoreBoardManager scoreBoardManager;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        scoreBoardManager = new ScoreBoardManager(new ScoreBoard());
    }

    public void testStartGameSuccess() {
        assertTrue(scoreBoardManager.startGame(new Match("Mexico", "Canada")));
        List<LiveMatch> liveMatchList = scoreBoardManager.getSummary();
        assertFalse(liveMatchList.isEmpty());
        assertEquals(liveMatchList.get(0).getMatchSummary(), "Mexico - Canada : 0 - 0");
    }

    public void testStartGameReturnsFalseWhenAnyTeamHasMatch() {
        assertTrue(scoreBoardManager.startGame(new Match("Mexico", "Canada")));
        assertFalse(scoreBoardManager.startGame(new Match("Mexico", "Turkey")));
    }

    public void testFinishGameSuccess() {
        scoreBoardManager.startGame(new Match("Mexico", "Canada"));
        assertFalse(scoreBoardManager.getSummary().isEmpty());
        scoreBoardManager.finishGame(new Match("Mexico", "Canada"));
        assertTrue(scoreBoardManager.getSummary().isEmpty());
    }

    public void testFinishGameFailForNonExistingMatch() {
        scoreBoardManager.startGame(new Match("Mexico", "Canada"));
        assertFalse(scoreBoardManager.getSummary().isEmpty());
        assertFalse(scoreBoardManager.finishGame(new Match("Mexico", "Turkey")));
    }

    public void testUpdateScore() {
        scoreBoardManager.startGame(new Match("Mexico", "Canada"));
        scoreBoardManager.updateScore(new LiveMatch("Mexico", 0, "Canada", 5));
        assertEquals(scoreBoardManager.getSummary().get(0).getMatchSummary(), "Mexico - Canada : 0 - 5");
    }

    public void testIncreaseScoreByTeamName() {
        scoreBoardManager.startGame(new Match("Mexico", "Canada"));
        scoreBoardManager.increaseScoreByTeamName("Mexico");
        assertEquals(scoreBoardManager.getSummary().get(0).getMatchSummary(), "Mexico - Canada : 1 - 0");
    }

    public void testGetSummary() {
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

        List<LiveMatch> actual = scoreBoardManager.getSummary();

        List<LiveMatch> expected = Arrays.asList(
                new LiveMatch("Uruguay", 6, "Italy", 6),
                new LiveMatch("Spain", 10,"Brazil", 2),
                new LiveMatch("Mexico", 0, "Canada", 5),
                new LiveMatch("Argentina", 3, "Australia", 1),
                new LiveMatch("Germany", 2, "France", 2)
        );

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getMatchSummary(), actual.get(i).getMatchSummary());
        }
    }
}