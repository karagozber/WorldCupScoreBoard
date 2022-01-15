package entities.concretes;

import java.util.List;

public class ScoreBoard {
    protected final List<LiveMatch> liveMatchList;

    public ScoreBoard(List<LiveMatch> liveMatchList) {
        this.liveMatchList = liveMatchList;
    }

    public List<LiveMatch> getLiveMatchList() {
        return liveMatchList;
    }
}
