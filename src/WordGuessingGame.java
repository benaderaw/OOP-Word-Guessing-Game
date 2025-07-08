import java.util.Random;

public class WordGuessingGame {
    public static void main(String[] args){
        System.out.println("OOP Practice - Word Guessing Game\n");

        StartGame startGame = new StartGame();
        GetRandomWord words = new GetRandomWord();

        System.out.println(words.wordDifficultyArray().getRandomWord());

        startGame.start();
    }
}
