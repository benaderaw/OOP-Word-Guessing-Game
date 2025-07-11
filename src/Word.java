import java.util.Arrays;

public class Word {
    private String chosenWord;
    private char[] wordCharArray;
    private char[] hiddenWordArray;

    // CONSTRUCTOR
    public Word(String chosenWord){
        this.chosenWord = chosenWord;
        this.wordCharArray = chosenWord.toCharArray();
        this.hiddenWordArray = new char[wordCharArray.length];
        Arrays.fill(hiddenWordArray, '_');
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
    public void checkGuessedLetter(char guessedLetter){
        for(int i = 0; i < wordCharArray.length; i++){
            if(wordCharArray[i] == guessedLetter){
                hiddenWordArray[i] = guessedLetter;
            }
        }
    }

    // reveal letter from hidden word
    public void revealGuessedWord(){
        for(int i = 0; i < wordCharArray.length; i++){
            hiddenWordArray[i] = wordCharArray[i];
        }

        for (char dash : hiddenWordArray) {
            System.out.print(dash + " ");
        }
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
    public boolean checkGuessedWord(String input, String chosenWord ){
        if(input.equals(chosenWord)){
            return true;
        }else{
            System.out.println("❌I'm sorry, '" + input + "' is not the correct word.");
        }

        return false;
    }


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


}
