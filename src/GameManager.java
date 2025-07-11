import java.util.Arrays;

public class GameManager {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private String chosenWord;
    private PlayerInput input;
    private Word word;
    String guessLetterInput;

    // CONSTRUCTOR
    public GameManager(Player player1, Player player2, String chosenWord, Word word){
        this.player1 = player1;
        this.player2 = player2;
        this.chosenWord = chosenWord;
        this.currentPlayer = player1;
        this.input = new PlayerInput();
        guessLetterInput = "*";
        this.word = word;
    }

    // METHODS
    public void playGame(){
        // display word as hidden
        System.out.print("\n");
        System.out.println(chosenWord);

        // current player
        currentPlayer = player1;
        System.out.println("========================  " + "🔷" + currentPlayer.getName() + "  ========================");


        while (true) {
            // if it's NOT players first turn
            if(currentPlayer.getHasGuessed()){
                // display player turn and hidden word
                displayPlayerTurn();
                displayHiddenWord();

                // prompt to solve word or guess letter
                guessLetterInput = input.guessLetterInput(word.getHiddenWordArray(), currentPlayer.getHasGuessed());
                word.checkGuessedLetter(guessLetterInput.charAt(0));

                if(guessLetterInput.equals("solve")){
                    // check is solve word guess is correct
                    checkSolveWordGuess(guessLetterInput);

                    if(currentPlayer.getIsSolved()){
                        break;
                    }

                    switchPlayer();
                    continue;
                }
            }else{
                // display player turn and hidden word
                displayPlayerTurn();
                displayHiddenWord();

                // if it's players first turn, player must guess
                guessLetterInput = input.guessLetterInput(word.getHiddenWordArray(), currentPlayer.getHasGuessed());
                currentPlayer.setHasGuessed(true);
            }

            // check if letter is in the chosen word
            if (!chosenWord.contains(guessLetterInput)) {
                System.out.println("❌Sorry " + currentPlayer.getName()+ ", '" + guessLetterInput + "' was not found in the hidden word, better luck next time...");
                switchPlayer();
            }else{
                // show how many letters found
                int numOfLettersFound = word.lettersFound(guessLetterInput.charAt(0));

                // get points
                currentPlayer.addScore(numOfLettersFound);

                // display letters found
                displayLettersFoundMessage(numOfLettersFound);

                // update and display the hidden word with found letter/s
                word.checkGuessedLetter(guessLetterInput.charAt(0));
                displayHiddenWord();
                
                // check if player found all the letters in the word
                if(new String(word.getHiddenWordArray()).equals(chosenWord)){
                    //
                    currentPlayer.addBonusScoreForLetterSolve(chosenWord);

                    // display score
                    System.out.println("✨+" + numOfLettersFound * 10 + " points plus +" + chosenWord.length() * 5 + " bonus points!");
                    displayScore();

                    // display winner
                    System.out.println("\n🎉🎉🎉" + currentPlayer.getName() + " has WON!!! 🎉🎉🎉");

                    // set current players isSolved property to true
                    currentPlayer.setIsSolved(true);
                    break;
                }

                // display score
                System.out.println("✨+" +  numOfLettersFound * 10 + " points");
                displayScore();
            }
        }
    }


    // switch player
    private void switchPlayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
        System.out.print("\n");

        String playerColor = currentPlayer == player1 ? "🔷" : "♦️";

        System.out.println("========================  " + playerColor + currentPlayer.getName() + "  ========================  ");
    }

    private void checkSolveWordGuess(String guessLetterInput){

        String solveGuessedWord = input.solveWordInput();
        boolean isSolved = word.checkGuessedWord(solveGuessedWord, chosenWord);

        // solved, game over, exit loop
        if(isSolved){
            // get the remaining hidden letters left
            int lettersLeft = word.lettersLeft();

            // add bonus score - lettersLeft * 10
            currentPlayer.addBonusScore(lettersLeft);

            //
            System.out.println("✅You did it! '" + solveGuessedWord + "' is the hidden word!");


            // update and display the hidden word with found letter/s
            System.out.print("🔎Hidden word: ");
            word.revealGuessedWord();

            // display score
            System.out.println("\n✨+" + lettersLeft * 10 + " bonus points!");
            displayScore();

            // display winner
            System.out.println("\n🎉🎉🎉" + currentPlayer.getName() + " has WON!!! 🎉🎉🎉");

            // set current players isSolved property to true
            currentPlayer.setIsSolved(true);

        }else{
            int lettersLeft = word.lettersLeft();
            // subtract score
            currentPlayer.subtractScore(lettersLeft);

            // update and display the hidden word with found letter/s
            System.out.print("🔎Hidden word: ");
            word.checkGuessedLetter(guessLetterInput.charAt(0));

            // display score
            System.out.println("\n✨-" + lettersLeft * 5 + " points");
            displayScore();
        }

    }

    // display player turn
    private void displayPlayerTurn(){
        System.out.printf("\n🎲Turn: %s \t\t ",currentPlayer.getName());
    }

    // display hidden word
    private void displayHiddenWord(){
        System.out.print("🔎Hidden word: ");
        word.displayHidden();
        System.out.print("\n");
    }
    
    // display letters found message
    private void displayLettersFoundMessage(int numOfLettersFound){
        String isOrAre = numOfLettersFound > 1 ? "are" : "is";
        String pluralOrSingular = numOfLettersFound > 1 ? "'s" : "'";
        System.out.print("✅There " + isOrAre + " " + numOfLettersFound + " '" + guessLetterInput +  pluralOrSingular + " in the hidden word.\n");
    }
    
    // display score
    private void displayScore(){
        System.out.printf("🔷%s: %d\n♦️%s: %d\n", player1.getName(), player1.getScore(), player2.getName(), player2.getScore());
    }
}
