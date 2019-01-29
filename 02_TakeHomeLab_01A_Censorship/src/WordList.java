import java.util.ArrayList;



public class WordList{
    protected ArrayList<Word> listOfWords;


    public WordList (ArrayList<Word> words) {
        this.listOfWords = words;
    }

    public void printCensoredStory(BadWords badWords) {
        for (Word w: listOfWords){
            String text = badWords.compareInputWordWithBadWords(w);
            System.out.print(text + " ");
        }

    }



}
