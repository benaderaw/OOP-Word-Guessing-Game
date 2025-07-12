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

    public char ccc(char[] hiddenWordArray){
        char hint;
        int length = hiddenWordArray.length;
        Random random = new Random();

        while (true){
            int ran = random.nextInt(0, length);

            if(hiddenWordArray[ran] == '_'){
                System.out.print("in hint: ");
                System.out.println(hiddenWordArray);
                System.out.println(wordCharArray[ran]);
                hint = wordCharArray[ran];
                break;
            }
        }

        return hint;
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
