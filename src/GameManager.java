import java.util.Arrays;

public class GameManager {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private String chosenWord;
    private PlayerInput input;
    private Word word;
    char guessedLetter;

    // CONSTRUCTOR
    public GameManager(Player player1, Player player2, String chosenWord, Word word){
        this.player1 = player1;
        this.player2 = player2;
        this.chosenWord = chosenWord;
        this.currentPlayer = player1;
        this.input = new PlayerInput();
        guessedLetter = '*';
        this.word = word;
    }


    // METHODS
    public void playGame(){
        // display word as hidden
        System.out.print(chosenWord);

        // current player
        currentPlayer = player1;

        while (true) {
            // if it's NOT players first turn
            if(currentPlayer.getHasGuessed()){
                // prompt to solve word or guess letter
                String guessOrSolver = input.guessOrSolve();
                // check is solve word guess is correct
                checkSolveWordGuess(guessOrSolver);

                if(currentPlayer.getIsSolved()){
                    break;
                }
            }

            // player turn and score display
            System.out.printf("\n\n🎲Turn: %s \t\t ",currentPlayer.getName());

            // hidden word display
            System.out.print("🔎Hidden word: ");
            word.revealGuessedLetter(guessedLetter);

            // if it's players first turn, player must guess
            guessedLetter = input.guessLetter(word.getHiddenWordArray());
            currentPlayer.setHasGuessed(true);

            // check if letter is in the chosen word
            if (!chosenWord.contains(String.valueOf(guessedLetter))) {
                System.out.println("❌Sorry " + currentPlayer.getName()+ ", '" + guessedLetter + "' was not found in the hidden word, better luck next time...");
                switchPlayer();
            }else{
                // show how many letters found
                int numOfLettersFound = word.lettersFound(guessedLetter);

                // get points
                currentPlayer.addScore(numOfLettersFound);

                // check plural or singular letters found for console output
                String isOrAre = numOfLettersFound > 1 ? "are" : "is";
                String pluralOrSingular = numOfLettersFound > 1 ? "'s" : "'";

                // display how many letters were found
                System.out.print("✅There " + isOrAre + " " + numOfLettersFound + " '" + guessedLetter +  pluralOrSingular + " in the hidden word: ");

                // update and display the hidden word with found letter/s
                word.revealGuessedLetter(guessedLetter);

                // display score
                System.out.println("\n✨+" +  numOfLettersFound * 10 + " points");
                System.out.printf("🔷%s: %d\n♦️%s: %d",player1.getName(), player1.getScore(), player2.getName(), player2.getScore());

                // check if player found all the letters in the word
                if(new String(word.getHiddenWordArray()).equalsIgnoreCase(chosenWord)){
                    currentPlayer.addBonusScoreForLetterSolve(chosenWord);
                    word.solved();
                    break;
                }
            }
        }
    }

    // switch player
    private void switchPlayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    private void checkSolveWordGuess(String guessOrSolve){
        if(guessOrSolve.equals("solve")){
            String solveGuessWord = input.solveWordInput();
            word.solveWord(solveGuessWord, currentPlayer, word);

            // solved, game over, exit loop
            if(currentPlayer.getIsSolved()){
                // add bonus score
                currentPlayer.addBonusScore(chosenWord);
            }else{
                // subtract score
                currentPlayer.subtractScore();

                // not solved, switch player
                switchPlayer();
            }
        }

    }
}
