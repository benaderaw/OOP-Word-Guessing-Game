public class Player {
    private String name;
    private int hintAmount;
    private PlayerScore playerScore;


    public Player(String name){
        this.name = name;
        this.hintAmount = 1;
        this.playerScore = new PlayerScore();
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

    public int getScore(){
        return playerScore.getScore();
    }


}
