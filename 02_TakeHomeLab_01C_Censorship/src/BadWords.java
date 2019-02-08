public class BadWords {
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
