public class GameManager {

    private Player player1;
    private Player player2;
    private String chosenWord;

    Word word = new Word();

    // CONSTRUCTOR
    public GameManager(Player player1, Player player2, String chosenWord){
        this.player1 = player1;
        this.player2 = player2;
        this.chosenWord = chosenWord;
    }

    // METHODS
    public void playGame(){
        // display word as hidden
        System.out.print("Hidden word: ");
        word.displayHiddenWord(chosenWord);
    }

}
