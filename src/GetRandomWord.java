import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GetRandomWord {
    Random random = new Random();

    private String randomWord;
    private ArrayList<String> wordDifficulty;


    public GetRandomWord pickRandomWord(String DifficultyChosen){
        // easy
        if(DifficultyChosen.equalsIgnoreCase("easy")){
            wordDifficulty = new ArrayList<>(Arrays.asList( "cat", "dog", "sun", "book", "car", "tree", "fish", "milk", "ball", "hat",
                    "shoe", "rain", "cake", "bird", "door", "star", "frog", "hand", "rock", "lamp"));
        }

        // medium
        if(DifficultyChosen.equalsIgnoreCase("medium")){
            wordDifficulty = new ArrayList<>(Arrays.asList( "pencil", "planet", "window", "animal", "forest", "bucket", "guitar", "rocket", "bottle", "monkey",
                    "saddle", "castle", "bridge", "button", "camera", "dragon", "flower", "silver", "jungle", "throat"));
        }

        // hard
        if(DifficultyChosen.equalsIgnoreCase("hard")){
            wordDifficulty = new ArrayList<>(Arrays.asList("newspaper", "handshake", "assignment", "connection", "environment",
                    "leadership", "personality", "houseplant", "friendship", "electricity",
                    "performance", "government", "bathroom", "playground", "neighborhood",
                    "celebration", "instruction", "lighthouse", "moonlight", "supermarket"));
        }


        randomWord = wordDifficulty.get(random.nextInt(0, wordDifficulty.size()));

        return this;
    }


    // GETTER
    public String getRandomWord(){
        return randomWord;
    }

}
