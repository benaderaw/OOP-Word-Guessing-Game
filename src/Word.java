import java.util.Arrays;

public class Word {
    private String chosenWord;
    private char[] wordCharArray;
    private char[] dashes;

    // CONSTRUCTOR
    public Word(){
        this.chosenWord = "";
        this.wordCharArray = new char['-'];
    }

    // METHODS
    // get chosen word
    private void getChosenWord(String chosenWord){
        this.chosenWord = chosenWord;
    }

    // convert word into char[]
    public void wordToCharArray(){
        wordCharArray = chosenWord.toCharArray();
    }

    // get number of letters found
    public int lettersFound(char guessedLetter){
        wordToCharArray();
        int num = 0;

        for(char letter: wordCharArray){
            if(letter == guessedLetter){
                num += 1;
            }
        }

        return num;
    }

    // reveal letter from hidden word
    public void revealGuessedLetter(char guessedLetter){
        for(int i = 0; i < wordCharArray.length; i++){
            if(wordCharArray[i] == guessedLetter){
                dashes[i] = guessedLetter;
            }
        }

        for (char dash : dashes) {
            System.out.print(dash + " ");
        }
    }


    // hide and display word
    public void displayHiddenWord(String chosenWord){
        getChosenWord(chosenWord);

        dashes = new char[chosenWord.length()];
        Arrays.fill(dashes, '_');

        for (char dash : dashes) {
            System.out.print(dash + " ");
        }
    }

}
