import java.util.Arrays;
import java.util.Random;

public class WordGuessingGame {
    public static void main(String[] args){
        System.out.println("OOP Practice - Word Guessing Game\n");

        char[] g = {'a', 'b', 'c'};

        System.out.println(new String(g).equals("abc"));


        StartGame startGame = new StartGame();

        startGame.start();
    }
}
