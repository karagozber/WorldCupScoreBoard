package entities.concretes;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    protected final List<LiveMatch> liveMatchList;

    public ScoreBoard() {
        this.liveMatchList = new ArrayList<>();
    }

    public List<LiveMatch> getLiveMatchList() {
        return liveMatchList;
    }
}
