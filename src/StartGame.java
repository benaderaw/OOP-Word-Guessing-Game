public class StartGame {

    private Player player1 = new Player("Player 1");
    private Player player2 = new Player("Player 2");

    PlayerInput playerInput = new PlayerInput();
    GetRandomWord randomWord = new GetRandomWord();
    Word word =  new Word();

    public void start(){
        System.out.println("🤖Welcome to the Word Guessing Game!");
        System.out.println("🤖This is a word solving game where you go up against a another \nplayer to see who solves the secret word first.");
        System.out.print("🤖Type 'start' or 's' to start game: ");

        // get players name
        player1.setName(playerInput.playerName("\n\nPlayer 1 name: "));
        player2.setName(playerInput.playerName("Player 2 name: "));

        // Welcome message
        System.out.printf("Welcome %s and %s, lets start the fun!", player1.getName(), player2.getName());

        // player choose difficulty
        playerInput.wordDifficulty();

        // get random word based on difficulty chosen
        String chosenWord = randomWord.pickRandomWord(playerInput.getDifficulty()).getRandomWord();

        // start game loop
        GameManager gameManager = new GameManager(player1, player2, chosenWord);
        gameManager.playGame();


    }
}
