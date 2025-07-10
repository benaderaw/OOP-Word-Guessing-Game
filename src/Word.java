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
    public void revealGuessedLetter(char guessedLetter){
        for(int i = 0; i < wordCharArray.length; i++){
            if(wordCharArray[i] == guessedLetter){
                hiddenWordArray[i] = guessedLetter;
            }
        }

        for (char dash : hiddenWordArray) {
            System.out.print(dash + " ");
        }
    }


    // get hidden word array
    public char[] getHiddenWordArray(){
        return hiddenWordArray;
    }

    // solve the word
    public void solveWord(String input, Player player, Word word ){
        if(input.equals(chosenWord)){
            System.out.println("\n🎉🎉🎉🎉 YOU WON  🎉🎉🎉🎉");
            player.setIsSolved(true);
        }else{
            System.out.println("🤖I'm sorry '" + input + "' is not the correct word.");
            System.out.print("\n[ Hidden word: ");
//            word.displayHiddenWord(chosenWord + "]");
            System.out.print("\n");
        }
    }

    // GETTER and SETTER
    public char[] getWordCharArray(){
        return wordCharArray;
    }


    // word solved
    public void solved(){
        System.out.println("\n\n🎉🎉🎉🎉 YOU WON  🎉🎉🎉🎉");
        System.out.println("🤖Congrats! you have guessed all the letters and solved the hidden word");
    }
}
