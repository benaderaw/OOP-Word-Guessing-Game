import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GetRandomWord {
    Random random = new Random();
    PlayerInput playerInput = new PlayerInput();

    private String randomWord;
    private ArrayList<String> wordDifficulty;


    public GetRandomWord wordDifficultyArray(){
        // easy
        if(playerInput.getDifficulty().equalsIgnoreCase("easy")){
            wordDifficulty = new ArrayList<>(Arrays.asList( "cat", "dog", "sun", "book", "car", "tree", "fish", "milk", "ball", "hat",
                    "shoe", "rain", "cake", "bird", "door", "star", "frog", "hand", "rock", "lamp"));
        }

        // medium
        if(playerInput.getDifficulty().equalsIgnoreCase("medium")){
            wordDifficulty = new ArrayList<>(Arrays.asList( "pencil", "planet", "window", "animal", "forest", "bucket", "guitar", "rocket", "bottle", "monkey",
                    "saddle", "castle", "bridge", "button", "camera", "dragon", "flower", "silver", "jungle", "throat"));
        }

        // hard
        if(playerInput.getDifficulty().equalsIgnoreCase("hard")){
            wordDifficulty = new ArrayList<>(Arrays.asList( "elephant", "sandwich", "umbrella", "backpack", "dinosaur", "mountain", "triangle", "microscope", "satellite", "whenever",
                    "airplane", "computer", "notebook", "hospital", "volcano", "language", "chocolate", "treasure", "president", "invisible"));
        }


        randomWord = wordDifficulty.get(random.nextInt(0, wordDifficulty.size()));


        return this;
    }


    // GETTER
    public String getRandomWord(){
        return randomWord;
    }

}
