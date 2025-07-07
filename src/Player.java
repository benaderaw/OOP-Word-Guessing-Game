public class Player {
    protected String name;
    protected int hintAmount;

    public Player(String name, int hintAmount){
        this.name = name;
        this.hintAmount = 1;
    }

    // GETTER
    public String getName(){
        return name;
    }

    public int getHintAmount(){
        return hintAmount;
    }

    // SETTER
    public void setName(String name){
        this.name = name;
    }

    public void setHintAmount(int hintAmount){
        this.hintAmount = hintAmount;
    }
}
