public class StartGame {

    private Player player1 = new Player("Player 1");
    private Player player2 = new Player("Player 2");
    private String currentPlayer;

    PlayerInput playerInput = new PlayerInput();

    public void start(){
        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Before wqe get started please provide player names...");


        // get players name
        player1.setName(playerInput.playerName("Player 1 name: "));
        player2.setName(playerInput.playerName("Player 2 name: "));


        System.out.printf("Welcome %s and %s, lets start the fun!", player1.getName(), player2.getName());

    }
}
