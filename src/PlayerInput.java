import java.util.Arrays;
import java.util.Scanner;

public class PlayerInput {
    private String playerInput;
    private String difficulty;
    private Scanner scanner = new Scanner(System.in);

    // CONSTRUCTS
    public PlayerInput(){
        this.playerInput = "";
        this.difficulty = "easy";
    }

    // METHODS
    // difficulty input and validation
    public void wordDifficulty(){
        while (true){
            System.out.print("\n🤖Choose word difficulty - type 'e' for easy / 'm' for medium / 'h' for hard: ");
            playerInput = scanner.nextLine().toLowerCase().trim();

            switch (playerInput) {
                case "easy":
                case "e":
                    difficulty = "easy";
                    break;
                case "medium":
                case "m":
                    difficulty = "medium";
                    break;
                case "hard":
                case "h":
                    difficulty = "hard";
                    break;
                default:
                    System.out.println("🔶Please choose difficulty...");
                    continue;
            }
            break;
        }
    }

    // player name input and validation
    public String playerName(String prompt){
        while (true){
            System.out.print(prompt);
            playerInput = scanner.nextLine().trim();

            if(playerInput.isEmpty()){
                System.out.println("🔶Please provide name...");
                continue;
            }
            break;
        }

        return playerInput;
    }

    // letter guess input and validation
    public String promptGuessOrSolve(char[] hiddenWordArray){
        while (true){
            System.out.print("🤖Keep guessing a letter, or type 'solve' to solve the word: ");
            playerInput = scanner.nextLine().toLowerCase().trim();

            if(playerInput.isEmpty()){
                System.out.println("🔶Please guess a letter or solve word...");
            }else if(playerInput.equals("solve")){
                return playerInput;
            }else if(new String(hiddenWordArray).contains(String.valueOf(playerInput.charAt(0)))){
                System.out.println("🔶'" + playerInput.charAt(0) + "' " + "has been already revealed, please guess another letter...");
            } else{
                return String.valueOf(playerInput.charAt(0));
            }
        }
    }

    public String firstTurnGuess(){
        while (true){
            System.out.print("🤖Guess a letter: ");
            playerInput = scanner.nextLine().toLowerCase().trim();

            if (playerInput.isEmpty()) {
                System.out.println("🔶Please guess a letter...");
                continue;
            }

            return String.valueOf(playerInput.charAt(0));
        }
    }

    // solve word input and validation
    public String promptSolveWord(){
        while (true){
            System.out.print("🤖Solve word guess: ");
            playerInput = scanner.nextLine().toLowerCase().trim();

            if(playerInput.isEmpty()){
                System.out.print("🔶Please solve the word...");
                continue;
            }
            break;
        }

        return playerInput;
    }

    // GETTER
    public String getDifficulty(){
        return difficulty;
    }
}
