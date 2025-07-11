import java.util.Arrays;

public class GameManager {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private String pickedWord;
    private PlayerInput input;
    private Word word;
    private String guessLetter;

    // CONSTRUCTOR
    public GameManager(Player player1, Player player2, String pickedWord, Word word){
        this.player1 = player1;
        this.player2 = player2;
        this.pickedWord = pickedWord;
        this.currentPlayer = player1;
        this.input = new PlayerInput();
        guessLetter = "*";
        this.word = word;
    }

    // MAIN  METHODS
    public void playGame(){
        // display word as hidden
        System.out.print("\n");
        System.out.println(pickedWord);

        // current player
        currentPlayer = player1;
        System.out.println("========================  " + "🔷" + currentPlayer.getName() + "  ========================");

        while (!word.getIsSolved()) {
            // display player turn and hidden word
            displayPlayerTurn();
            displayHiddenWord();

            // if it's NOT players first turn
            if(!currentPlayer.getHasGuessed()){
                promptFirstTurnGuess();
            }else{
                // prompt to solve word or guess letter
                promptGuessOrSolve();

                if(guessLetter.equals("solve")){
                    processSolveAttempt();

                    if(word.getIsSolved()) {
                        handleCorrectSolve();
                        break;
                    }else{
                        handleIncorrectSolve();
                        continue;
                    }
                }
            }

            // check if letter is in the chosen word
            handleGuessAttempt();
        }
    }

    // SUPPORT METHODS
    // switch player
    private void switchPlayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
        System.out.print("\n");
        String playerColor = currentPlayer == player1 ? "🔷" : "♦️";
        System.out.println("========================  " + playerColor + currentPlayer.getName() + "  ========================  ");
    }
    
    // display player turn
    private void displayPlayerTurn(){
        System.out.printf("🎲Turn: %s \t\t ",currentPlayer.getName());
    }

    // display hidden word
    private void displayHiddenWord(){
        System.out.print("🔎Hidden word: ");
        word.displayHidden();
        System.out.print("\n");
    }

    // process first turn
    private void promptFirstTurnGuess(){
        // if it's players first turn, player must guess
        guessLetter = input.firstTurnGuess();
        currentPlayer.setHasGuessed(true);
    }

    // after first guess
    private void promptGuessOrSolve(){
        guessLetter = input.promptGuessOrSolve(word.getHiddenWordArray());
    }

    // check if solve word is correct
    private void processSolveAttempt(){
        String guessedWord = input.promptSolveWord();
        word.processSolveWord(guessedWord);
    }

    // check if guessed letter is in the pickedWord
    public void handleGuessAttempt(){
        word.checkGuessedLetter(guessLetter);

        if (!pickedWord.contains(guessLetter)) {
            System.out.println("❌Sorry " + currentPlayer.getName()+ ", '" + guessLetter + "' was not found in the hidden word, better luck next time...");
            switchPlayer();
        }else{
            // show how many letters found
            int numOfLettersFound = word.lettersFound(guessLetter.charAt(0));

            // get points
            currentPlayer.addScore(numOfLettersFound);

            // display letters found
            displayLettersFoundMessage(numOfLettersFound);

            // update and display the hidden word with found letter/s
            word.checkGuessedLetter(guessLetter); // updates hidden word with found letter/s
            displayHiddenWord();

            // check if player found all the letters in the word
            if(new String(word.getHiddenWordArray()).equals(pickedWord)){
                currentPlayer.addBonusScoreForLetterSolve(pickedWord);

                // display score
                System.out.println("✨+" + numOfLettersFound * 10 + " points plus +" + pickedWord.length() * 5 + " bonus points!");
                displayScore();

                // display winner
                System.out.println("🎉🎉🎉" + currentPlayer.getName() + " has WON!!! 🎉🎉🎉");

                // set current players isSolved property to true
                currentPlayer.setIsSolved(true);
                word.setSolved(true);
            }

            if(!word.getIsSolved()){
                displayPoints(numOfLettersFound);
                displayScore();
            }
        }
    }

    private void displayPoints(int numOfLettersFound){
        System.out.println("✨+" + numOfLettersFound * 10 + " points");
    }
    
    // handle incorrect solve word
    private void handleIncorrectSolve(){
        // subtract score
        int lettersLeft = word.lettersLeft();
        currentPlayer.subtractScore(lettersLeft);

        // update and display the hidden word with found letter/s
        System.out.print("🔎Hidden word: ");
        word.checkGuessedLetter(guessLetter);

        // display score
        System.out.println("✨-" + lettersLeft * 5 + " points");
        displayScore();
        switchPlayer();
    }

    // correct solve display
    public void handleCorrectSolve(){
        // get the remaining hidden letters left
        int lettersLeft = word.lettersLeft();

        addBonusScore(lettersLeft);

        System.out.println("✅You did it! '" + pickedWord + "' is the hidden word!");

        // update and display the hidden word with found letter/s
        System.out.print("🔎Hidden word: ");
        word.revealGuessedWord();

        // display score
        System.out.println("\n✨+" + lettersLeft * 10 + " bonus points!");
        displayScore();

        // display winner
        System.out.println("🎉🎉🎉" + currentPlayer.getName() + " has WON!!! 🎉🎉🎉");
    }

    // display letters found message
    private void displayLettersFoundMessage(int numOfLettersFound){
        String isOrAre = numOfLettersFound > 1 ? "are" : "is";
        String pluralOrSingular = numOfLettersFound > 1 ? "'s" : "'";
        System.out.print("✅There " + isOrAre + " " + numOfLettersFound + " '" + guessLetter +  pluralOrSingular + " in the hidden word.\n");
    }
    
    // display score
    private void displayScore(){
        System.out.printf("🔷%s: %d\n♦️%s: %d\n\n", player1.getName(), player1.getScore(), player2.getName(), player2.getScore());
    }

    // add bonus score for solved word
    private void addBonusScore(int lettersLeft){
        currentPlayer.addBonusScore(lettersLeft);
    }
}
