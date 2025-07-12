import java.util.Arrays;
import java.util.Random;

public class Hint extends Word {
    private char hintLetter;
    private boolean hintDisabled;

    public Hint(String pickedWord) {
        super(pickedWord);
        hintLetter = '*';
        this.hintDisabled = false;
    }

    public char getHint(char[] hiddenWordArray) {
        char hint;
        int length = hiddenWordArray.length;
        Random random = new Random();

        while (true) {
            int ran = random.nextInt(0, length);

            if (hiddenWordArray[ran] == '_') {
                hint = wordCharArray[ran];
                break;
            }
        }

        return hint;
    }

    public int hiddenLetterLeft(char[] hiddenWordArray) {
        int numOfHiddenLeft = 0;

        for (char letter : hiddenWordArray) {
            if (letter == '_') {
                numOfHiddenLeft += 1;
            }
        }

        return numOfHiddenLeft;
    }

    public boolean isHintDisabled() {
        return hintDisabled;
    }

    public void setHintDisabled(boolean hintDisabled) {
        this.hintDisabled = hintDisabled;
    }


}


