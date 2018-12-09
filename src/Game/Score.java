package Game;

public class Score {
    private int score=0;

    public int getScore() {
        return score;
    }

    public void addScore() {
       score++;
    }

    public void showScore(){
        GameInfo.printGameInfo(this);
    }
}
