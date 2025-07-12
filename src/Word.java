import java.util.ArrayList;
import java.util.Arrays;

public class Word {
    protected String pickedWord;
    protected char[] wordCharArray;
    protected char[] hiddenWordArray;
    protected boolean solved;
    protected ArrayList<String> guessedLetters;


    // CONSTRUCTOR
    public Word(String pickedWord){
        this.pickedWord = pickedWord;
        this.wordCharArray = pickedWord.toCharArray();
        this.hiddenWordArray = new char[wordCharArray.length];
        Arrays.fill(hiddenWordArray, '_');
        this.solved = false;
        this.guessedLetters = new ArrayList<>();
    }

    // METHODS
    // get number of letters found
    public int lettersFound(char guessedLetter){
        int num = 0;

        for(char letter: wordCharArray){
            if(letter == guessedLetter){
                num += 1;
            }
        }

        return num;
    }

    // reveal letter from hidden word
    public void checkGuessedLetter(String guessedLetter){
        char letter = guessedLetter.charAt(0);

        if(pickedWord.contains(String.valueOf(letter))){
            for(int i = 0; i < wordCharArray.length; i++){
                if(wordCharArray[i] == letter){
                    hiddenWordArray[i] = letter;
                }
            }
        }

    }

    public void guessedLetter(String guessLetter){
        if(guessedLetters.isEmpty()){
            guessedLetters.add(guessLetter);
        }else{
            if(!guessedLetters.contains(guessLetter)){
                guessedLetters.add(guessLetter);
            }
        }

        System.out.println(guessedLetters);
    }

    public void displayHidden(){
        for (char dash : hiddenWordArray) {
            System.out.print(dash + " ");
        }
    }

    // get hidden word array
    public char[] getHiddenWordArray(){
        return hiddenWordArray;
    }

    // solve the word
    public void processSolveWord(String input){
        if(input.equals(pickedWord)){
             solved = true;
        }
    }

    // reveal letter from hidden word
    public void revealGuessedWord(){
        for (char letter : wordCharArray) {
            System.out.print(letter + " ");
        }
    }

    // check num of letters that were not guessed
    public int lettersLeft(){
        int num = 0;

        for(char dash: hiddenWordArray){
            if(dash == '_'){
                num += 1;
            }
        }
        return num;
    }

    // GETTER and SETTER
    public boolean isSolved(){
        return solved;
    }

    public void setSolved(boolean solved){
        this.solved = solved;
    }


}
