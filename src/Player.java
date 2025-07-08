public class Player {
    private String name;
    private int hintAmount;
    private PlayerScore playerScore;
    private String playerResponse;


    public Player(String name){
        this.name = name;
        this.hintAmount = 1;
        this.playerScore = new PlayerScore();
        this.playerResponse = "";
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


}
