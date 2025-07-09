public class PlayerScore {
    public int score;

    public PlayerScore(){
        this.score = 0;
    }

    // METHODS
    public int addScore(){
        return score += 10;
    }

    public int subtractScore(){
        return score -= 20;
    }

    public int addBonusScore(String word){
        return score += (word.length() * 10);
    }

    // GETTER and SETTER
    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }
}
