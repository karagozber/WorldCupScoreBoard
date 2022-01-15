package entities.concretes;

import entities.abstracts.Entity;

public class Match implements Entity {
    protected final String homeTeam;
    protected final String awayTeam;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }
}
