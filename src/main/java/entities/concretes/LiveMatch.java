package entities.concretes;

public class LiveMatch extends Match{
    private int homeScore;
    private int awayScore;

    public LiveMatch(String homeTeam, String awayTeam) {
        super(homeTeam, awayTeam);
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }
}
