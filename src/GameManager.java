public class GameManager {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private String chosenWord;
    private PlayerInput input;


    Word word = new Word();

    // CONSTRUCTOR
    public GameManager(Player player1, Player player2, String chosenWord){
        this.player1 = player1;
        this.player2 = player2;
        this.chosenWord = chosenWord;
        this.currentPlayer = player1;
        this.input = new PlayerInput();
    }

    // METHODS
    public void playGame(){
        // display word as hidden
        System.out.print(chosenWord);
        System.out.print("\nHidden word: ");
        word.displayHiddenWord(chosenWord);

        // current player
        currentPlayer = player1;

        while (true) {
            // player
            System.out.println("\n=== " + currentPlayer.getName() + " ====");

            // player 1 guess prompt and validation
            char guessedLetter = input.guessLetter("Guess the letter: ");

            // check if letter is in the chosen word
            if (!chosenWord.contains(String.valueOf(guessedLetter))) {
                System.out.println("\n" + guessedLetter + " was not found in the hidden word, better luck next time...");
                switchPlayer();
            }else{
                System.out.println("\nNICE! " + guessedLetter + " was found in the hidden word...");
                System.out.println("👍");
            }
        }
    }

    // switch player
    private void switchPlayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

}
