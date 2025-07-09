import java.util.Scanner;

public class PlayerInput {
    private String playerInput;
    private String difficulty;
    private Scanner scanner = new Scanner(System.in);



    public PlayerInput(){
        this.playerInput = "";
        this.difficulty = "easy";
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

    // guess or solve input and validation
    public String guessOrSolve(){
        while (true){
            System.out.print("Would you like to guess another letter or solve the word: ");
            playerInput = scanner.nextLine().trim();

            switch (playerInput.toLowerCase().trim()){
                case "guess":
                    break;
                case "solve":
                    break;
                default:
                    System.out.print("🔶Type 'guess' for 'solve' to continue...");
                    continue;
            }
            break;
        }

        return playerInput;
    }

    // letter guess input and validation
    public char guessLetter(){
        char playerGuessInput;

        while (true){
            System.out.print("Guess the letter: ");
            playerInput = scanner.nextLine().trim().toLowerCase();

            if(playerInput.isEmpty()){
                System.out.println("🔶Please enter a letter...");
            }else{
                playerGuessInput = playerInput.charAt(0);
                break;
            }
        }

        return playerGuessInput;
    }

    // solve word input and validation
    public String solveWord(){
        while (true){
            System.out.print("Solve guess: ");
            playerInput = scanner.nextLine().toLowerCase().trim();

            if(playerInput.isEmpty()){
                System.out.print("🔶Please solve the word...");
                continue;
            }
            break;
        }

        return playerInput;
    }

    // difficulty input and validation
    public void wordDifficulty(){
        while (true){
            System.out.print("\nChoose word difficulty - 'easy or e' / 'medium or m' / 'hard or h': ");
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

    // GETTER
    public String getDifficulty(){
        return difficulty;
    }
}
