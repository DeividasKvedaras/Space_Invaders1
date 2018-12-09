package Game;

public class GameInfo {

    public static void printGameInfo(Score score) {
        System.out.println("Your current score is:" + score.getScore());
    }

    public static void printGameOver(Score score){
        System.out.println("GAME OVER!!! \nYour final score is:" + score.getScore());
    }

    public static void printWinningText(Score score){
        System.out.println("You won!!! \nYour final score is:" + score.getScore());
    }
}
