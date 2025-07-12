public class PlayerScore {
    private int score;

    public PlayerScore(){
        this.score = 0;
    }

    // METHODS
    // per correct letter
    public int addScore(int numOfLettersFound){
        return score += numOfLettersFound * 10;
    }

    // if solve word guess is wrong
    public int subtractScore(int lettersLeft){
        return score -= lettersLeft * 5;
    }

    // if solve guess is right
    public int addBonusScore(int lettersLeft){
        return score += lettersLeft * 10;
    }

    // if hidden word is solved by guessing letters
    public int addBonusScoreForLetterSolve(String word){
        return score += word.length() * 5;
    }

    // GETTER and SETTER
    public int getScore(){
        return score;
    }

}
