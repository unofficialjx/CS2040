import java.util.ArrayList;


public class Story {
    private ArrayList<Word> storyWords;

    public Story(ArrayList<Word> storyWords) {
        this.storyWords = storyWords;
    }

    public void printCensoredStory(BadWords badWords) {

        for (int i = 0; i < storyWords.size() - 1; i++){
            String text = badWords.compareInputWordWithBadWordsAndCensor(storyWords.get(i));
            System.out.print(text + " ");
        }

        Word finalWord = storyWords.get(storyWords.size() - 1);
        String finalWordText = badWords.compareInputWordWithBadWordsAndCensor(finalWord);
        System.out.println(finalWordText);
    }



}