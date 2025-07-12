public class Player {
    private String name;
    private int hintAmount;
    private PlayerScore playerScore;
    private String playerResponse;
    private boolean guessed;
    private boolean usedHint;
    private int numOfHints;



    public Player(String name){
        this.name = name;
        this.hintAmount = 1;
        this.playerScore = new PlayerScore();
        this.playerResponse = "";
        this.guessed = false;
        this.usedHint = false;
        this.numOfHints = 1;
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

    public void setGuessed(boolean guessed){
        this.guessed  = guessed;
    }

    public boolean hasUsedHint(){
        return usedHint;
    }

    public void setUsedHint(boolean usedHint){
        this.usedHint = usedHint;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNumOfHints(){
        return numOfHints;
    }

    public void setNumOfHints(int numOfHints) {
        this.numOfHints = numOfHints;
    }
}

