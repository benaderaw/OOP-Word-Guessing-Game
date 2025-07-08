import java.util.Scanner;

public class PlayerInput {
    private String playerInput;
    private Scanner scanner = new Scanner(System.in);

    public PlayerInput(){
        this.playerInput = "";
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
    public String guessOrSolve(String prompt){
        while (true){
            System.out.print(prompt);
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
    public char guessedLetter(String prompt){
        char playerGuessInput;

        while (true){
            System.out.print(prompt);
            playerInput = scanner.next().trim().toLowerCase();

            if(playerInput.isEmpty()){
                System.out.print("🔶Please enter a letter...");
                continue;
            }else{
                playerGuessInput = playerInput.charAt(0);
                break;
            }
        }

        return playerGuessInput;
    }
}
