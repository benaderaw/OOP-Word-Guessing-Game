public class PlayerScore {
    public int score;

    public PlayerScore(){
        this.score = 0;
    }

    // METHODS
    // per correct letter
    public int addScore(){
        return score += 10;
    }

    // if solve word guess is wrong
    public int subtractScore(){
        return score -= 20;
    }

    // if solve guess is right
    public int addBonusScore(String word){
        return score += (word.length() * 10);
    }

    // if hidden word is solved by guessing letters
    public int addBonusScoreForLetterSolve(String word){
        return score += word.length() * 5;
    }

    // GETTER and SETTER
    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }
}
