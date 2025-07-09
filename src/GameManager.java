public class GameManager {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private String chosenWord;
    private PlayerInput input;


    Word word = new Word();
    PlayerScore playerScore = new PlayerScore();

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
            char guessedLetter = input.guessLetter(word.getDashes());

            // check if letter is in the chosen word
            if (!chosenWord.contains(String.valueOf(guessedLetter))) {
                System.out.println("\n" + guessedLetter + " was not found in the hidden word, better luck next time...");
                switchPlayer();
            }else{
                // get points
                currentPlayer.addScore();

                // show how many letters found
                int numOfLettersFound = word.lettersFound(guessedLetter);
                System.out.println("There are " + numOfLettersFound + " " + guessedLetter + " in the hidden word.");

                // reveal letter in hidden word
                System.out.print("\nHidden word: ");
                word.revealGuessedLetter(guessedLetter);

                // solve word or guess more letters
                String guessOrSolve = input.guessOrSolve();

                // if solve check correctness
                if(guessOrSolve.equals("solve")){
                    String solveGuessWord = input.solveWord();
                    word.solveWord(solveGuessWord, currentPlayer);

                    // solved, game over, exit loop
                    if(currentPlayer.getIsSolved()){
                        // add bonus score
                        currentPlayer.addBonusScore(chosenWord);
                        break;
                    }

                    // subtract score
                    currentPlayer.subtractScore();

                    // not solved, switch player
                    switchPlayer();
                }
            }
        }
    }

    // switch player
    private void switchPlayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

}
