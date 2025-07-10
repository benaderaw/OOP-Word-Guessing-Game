public class Player {
    private String name;
    private int hintAmount;
    private PlayerScore playerScore;
    private String playerResponse;
    private boolean isSolved;
    private boolean hasGuessed;


    public Player(String name){
        this.name = name;
        this.hintAmount = 1;
        this.playerScore = new PlayerScore();
        this.playerResponse = "";
        this.isSolved= false;
    }

    // GETTER
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHintAmount(){
        return hintAmount;
    }

    public void setHintAmount(int hintAmount){
        this.hintAmount = hintAmount;
    }

    public String getPlayerResponse(){
        return playerResponse;
    }

    public int getScore(){
        return playerScore.getScore();
    }

    public boolean getIsSolved(){
        return isSolved;
    }

    public void setIsSolved(boolean isSolved){
        this.isSolved = isSolved;
    }

    public int addScore(int numOfLettersFound){
        return playerScore.addScore(numOfLettersFound);
    }

    public int subtractScore(){
        return playerScore.subtractScore();
    }

    public int addBonusScore(String word){
        return playerScore.addBonusScore(word);
    }

    public int addBonusScoreForLetterSolve(String word){
        return playerScore.addBonusScoreForLetterSolve(word);
    }

    public boolean getHasGuessed(){
        return hasGuessed;
    }

    public void setHasGuessed(boolean hasGuessed){
        this.hasGuessed  = hasGuessed;
    }

}
