public class StartGame {

    private Player player1 = new Player("Player 1");
    private Player player2 = new Player("Player 2");

    PlayerInput playerInput = new PlayerInput();
    GetRandomWord randomWord = new GetRandomWord();

    public void start(){
        System.out.println("🤖Welcome to the Word Guessing Game!");
        System.out.println("🤖This is a word solving game where you go up against a another \nplayer to see who solves the secret word first.");

        // get players name
//        System.out.print("🤖Before we start lets get your names...\n\n");
        player1.setName(playerInput.playerName("🔷Player 1 name: "));
        player2.setName(playerInput.playerName("♦️Player 2 name: "));

        // Welcome message
        System.out.printf("🤖Welcome %s and %s, lets start the fun!", player1.getName(), player2.getName());

        // player choose difficulty
        playerInput.wordDifficulty();

        // get random word based on difficulty chosen
        String chosenWord = randomWord.pickRandomWord(playerInput.getDifficulty()).getRandomWord();

        // pass chosen word to word object
        Word word = new Word(chosenWord);

        // start game loop
        GameManager gameManager = new GameManager(player1, player2, chosenWord, word);
        gameManager.playGame();


    }
}
