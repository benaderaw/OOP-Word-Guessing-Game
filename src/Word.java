import java.util.Arrays;

public class Word {

    private String chosenWord;

    // CONSTRUCTOR
    public Word(){
        this.chosenWord = "";
    }

    // METHODS
    // get chosen word
    private void getChosenWord(String chosenWord){
        this.chosenWord = chosenWord;
    }

    // hide and display wor
    public void displayHiddenWord(String chosenWord){
        getChosenWord(chosenWord);

        for(int i = 0; i < this.chosenWord.length(); i++){
            System.out.print("_ ");
        }
    }

}
