import java.util.Arrays;
import java.util.Random;

public class Hint extends Word{
    private char hintLetter;
    private boolean disableHint;

    public Hint(String pickedWord) {
        super(pickedWord);
        hintLetter = '*';
        this.disableHint = false;
    }

    public char ccc(){
        int length = this.hiddenWordArray.length;
        Random random = new Random();

        while (true){
            int ran = random.nextInt(0, length);

            if(hiddenWordArray[ran] == '_'){
                System.out.println(wordCharArray[ran]);
                return wordCharArray[ran];
            }
        }
    }

    public int lastLetter(){
        int numOfHiddenLeft = 0;

        for(char letter : hiddenWordArray){
            if(letter == '_'){
                numOfHiddenLeft += 1;
            }
        }

        return numOfHiddenLeft;
    }

    public void setDisableHint(boolean disableHint){
        this.disableHint = disableHint;
    }


}
