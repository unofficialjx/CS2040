/**
 * Name         : KENG JUN XIAN
 * Matric. No   : A0167718R
 * PLab Acct.   :
 */

import java.util.*;

public class Censorship {

    private static class Word {
        private String text;
        private int wordLength;

        public Word(String text) {
            this.text = text;
            this.wordLength = text.length();
        }


        protected boolean isBadWord(Word badWord) {
            if (this.text.compareToIgnoreCase(badWord.text) == 0) {
                return true;
            }

            return false;
        }

        protected static String censorWord(Word badWord) {
            String censoredWord = "";
            for (int i = 0; i < badWord.wordLength; i++) {
                censoredWord = censoredWord.concat("*");
            }

            return censoredWord;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return this.text;
        }
    }


    private class BadWords {
        private int size;
        Word[] badWordsArray;

        public BadWords(int size) {
            this.size = size;
            this.badWordsArray = new Word[this.size];
        }

        String compareInputWordWithBadWordsAndCensor(Word w) {
            for (Word bw: badWordsArray) {

                if (w.isBadWord(bw)) {
                    return Word.censorWord(w);
                }
            }

            return w.getText();
        }

        void addToBadWordsArray(Word w, int index){
            badWordsArray[index] = w;
        }

    }



    private class Story {
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

    private void run() {
        ArrayList<Word> story = new ArrayList<Word>();
        BadWords vulgarities;
        int numOfBadWords;
        Scanner sc = new Scanner(System.in);

        numOfBadWords = sc.nextInt();
        vulgarities = new BadWords(numOfBadWords);
        sc.nextLine();


        for (int i = 0; i < numOfBadWords; i++) {
            String badWordText = sc.next();
            Word bw = new Word(badWordText);
            vulgarities.addToBadWordsArray(bw, i);
        }
        sc.nextLine();


        while (sc.hasNext()) {
            String wordText = sc.next();
            Word storyWord = new Word(wordText);
            story.add(storyWord);
        }


        Story s1 = new Story(story);
        s1.printCensoredStory(vulgarities);
    }

    public static void main(String[] args) {
        Censorship newCensorship = new Censorship();
        newCensorship.run();
    }


}
