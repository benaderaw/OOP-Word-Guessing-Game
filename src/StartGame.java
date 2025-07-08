public class StartGame {

    private Player player1 = new Player("Player 1");
    private Player player2 = new Player("Player 2");
    private String currentPlayer;

    PlayerInput playerInput = new PlayerInput();
    GetRandomWord randomWord = new GetRandomWord();
    Word word =  new Word();

    public void start(){
        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Before wqe get started please provide player names...");


        // get players name
        player1.setName(playerInput.playerName("Player 1 name: "));
        player2.setName(playerInput.playerName("Player 2 name: "));

        // Welcome message
        System.out.printf("Welcome %s and %s, lets start the fun!", player1.getName(), player2.getName());

        // player choose difficulty
        playerInput.wordDifficulty("\nChoose word difficulty - 'easy or e' / 'medium or m' / 'hard or h': "); // hard

        // get random word based on difficulty chosen
//      System.out.println(randomWord.pickRandomWord(playerInput.getDifficulty()).getRandomWord());
        String chosenWord = randomWord.pickRandomWord(playerInput.getDifficulty()).getRandomWord();

        // show hidden word
        System.out.print("Hidden word: ");
        word.displayHiddenWord(chosenWord);
    }
}
