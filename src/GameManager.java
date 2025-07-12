import java.util.Arrays;
import java.util.Enumeration;

public class GameManager {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private String pickedWord;
    private PlayerInput input;
    private Word word;
    private String guessLetter;
    private String guessedWord;

    // CONSTRUCTOR
    public GameManager(Player player1, Player player2, String pickedWord, Word word){
        this.player1 = player1;
        this.player2 = player2;
        this.pickedWord = pickedWord;
        this.currentPlayer = player1;
        this.input = new PlayerInput();
        this.guessLetter = "*";
        this.word = word;
        this.guessedWord = "";
    }

    // MAIN  METHODS
    public void playGame(){
        // display word as hidden
        System.out.print("\n");
        System.out.println(pickedWord);

        Hint hint = new Hint(pickedWord);

        // current player
        currentPlayer = player1;
        System.out.println("========================  " + "🔷" + currentPlayer.getName() + "  ========================");

        while (!word.isSolved()) {
            int lettersLeft = hint.lettersLeft();
            System.out.print(lettersLeft);

            if(lettersLeft == 1){
                hint.setDisableHint(true);
            }

            // display player turn and hidden word
            displayPlayerTurn();
            displayHiddenWord();

            // if it's players first turn
            if(!currentPlayer.hasGuessed()){
                promptFirstTurnGuess();
            }else{
                // prompt to solve word or guess letter
                promptGuessOrSolve();

                if(guessLetter.equals("hint")){
                    // TEST
                    String ff = String.valueOf(hint.ccc());
                    System.out.print("Hint word is: " + ff);
                    System.out.print("\n");
                }else if(guessLetter.equals("solve")){
                    checkSolveAttempt();

                    if(word.isSolved()) {
                        handleCorrectSolve();
                        break;
                    }else{
                        handleIncorrectSolve();
                        continue;
                    }
                }
            }

            // check if letter is in the chosen word
            checkGuessAttempt();

        }
    }

    // SUPPORT METHODS
    public void handleHint(){

    }

    private void switchPlayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
        System.out.print("\n");
        String playerColor = currentPlayer == player1 ? "🔷" : "♦️";
        System.out.println("========================  " + playerColor + currentPlayer.getName() + "  ========================  ");
    }
    
    private void displayPlayerTurn(){
        System.out.printf("🎲Turn: %s \t\t ",currentPlayer.getName());
    }

    private void displayHiddenWord(){
        System.out.print("🔎Hidden word: ");
        word.displayHidden();
        System.out.print("\n");
    }

    private void displayIncorrectSolveMessage(){
        System.out.println("❌Sorry " + currentPlayer.getName() + ", '" + guessedWord +  "' is not the hidden word.");
    }

    private void displayPoints(int numOfLettersFound){
        System.out.println("✨+" + numOfLettersFound * 10 + " points");
    }

    private void displayScore(){
        System.out.printf("🔷%s: %d\n♦️%s: %d\n\n", player1.getName(), player1.getScore(), player2.getName(), player2.getScore());
    }

    private void displayLettersFoundMessage(int numOfLettersFound){
        String isOrAre = numOfLettersFound > 1 ? "are" : "is";
        String pluralOrSingular = numOfLettersFound > 1 ? "'s" : "'";
        System.out.print("✅There " + isOrAre + " " + numOfLettersFound + " '" + guessLetter +  pluralOrSingular + " in the hidden word.\n");
    }

    private void promptFirstTurnGuess(){
        // if it's players first turn, player must guess
        guessLetter = input.firstTurnGuess();
        currentPlayer.setHasGuessed(true);
    }

    // standard prompt after first guess
    private void promptGuessOrSolve(){
        guessLetter = input.promptGuessOrSolve(word.getHiddenWordArray());
    }

    // display incorrect letter message
    private void displayIncorrectLetterMessage(){
        System.out.println("❌Sorry " + currentPlayer.getName()+ ", '" + guessLetter + "' was not found in the hidden word, better luck next time...");
    }

    private void handleCorrectLetter(int numOfLettersFound){
        // get points
        currentPlayer.addScore(numOfLettersFound);

        // display letters found
        displayLettersFoundMessage(numOfLettersFound);

        // update and display the hidden word with found letter/s
        word.checkGuessedLetter(guessLetter); // updates hidden word with found letter/s
        displayHiddenWord();
    }

    private void checkSolveByLetter(int numOfLettersFound){
        if(new String(word.getHiddenWordArray()).equals(pickedWord)){
            currentPlayer.addBonusScoreForLetterSolve(pickedWord);

            // display score
            System.out.println("✨+" + numOfLettersFound * 10 + " points plus +" + pickedWord.length() * 5 + " bonus points!");
            displayScore();

            // display winner
            System.out.println("🎉🎉🎉" + currentPlayer.getName() + " has WON!!! 🎉🎉🎉");

            // set current players isSolved property to true
            word.setSolved(true);
        }
    }

    public void checkGuessAttempt(){
        if (!pickedWord.contains(guessLetter)) {
            displayIncorrectSolveMessage();
            switchPlayer();
        }else{
            // show how many letters found
            int numOfLettersFound = word.lettersFound(guessLetter.charAt(0));

            handleCorrectLetter(numOfLettersFound);

            // check if player found all the letters in the word
            checkSolveByLetter(numOfLettersFound);

            if(!word.isSolved()){
                displayPoints(numOfLettersFound);
                displayScore();
            }
        }
    }

    private void checkSolveAttempt(){
        guessedWord = input.promptSolveWord();
        word.processSolveWord(guessedWord);
    }

    private void handleCorrectSolve(){
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

    private void handleIncorrectSolve(){
        // subtract score
        int lettersLeft = word.lettersLeft();
        currentPlayer.subtractScore(lettersLeft);

        // update and display the hidden word with found letter/s
        displayHiddenWord();
        displayIncorrectSolveMessage();

        // display score
        System.out.println("✨-" + lettersLeft * 5 + " points");
        displayScore();
        switchPlayer();
    }

    // add bonus score for solved word
    private void addBonusScore(int lettersLeft){
        currentPlayer.addBonusScore(lettersLeft);
    }
}
