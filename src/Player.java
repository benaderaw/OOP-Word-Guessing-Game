public class Player {
    private String name;
    private int hintAmount;
    private PlayerScore playerScore;
    private String playerResponse;
    private boolean guessed;


    public Player(String name){
        this.name = name;
        this.hintAmount = 1;
        this.playerScore = new PlayerScore();
        this.playerResponse = "";
        this.guessed = false;
    }

    // GETTER
    public String getName(){
        return name;
    }

    public int getScore(){
        return playerScore.getScore();
    }

    public int addScore(int numOfLettersFound){
        return playerScore.addScore(numOfLettersFound);
    }

    public int subtractScore(int lettersLeft){
        return playerScore.subtractScore(lettersLeft);
    }

    public int addBonusScore(int lettersLeft){
        return playerScore.addBonusScore(lettersLeft);
    }

    public int addBonusScoreForLetterSolve(String word){
        return playerScore.addBonusScoreForLetterSolve(word);
    }

    public boolean hasGuessed(){
        return guessed;
    }

    public void setHasGuessed(boolean guessed){
        this.guessed  = guessed;
    }

    public void setName(String name){
        this.name = name;
    }

}
