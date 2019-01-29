
public class BadWords  {
    private int size;
    private Word[] badWordsArray;

    public BadWords(int size) {
        this.size = size;
        this.badWordsArray = new Word[size];
    }

    String compareInputWordWithBadWords(Word w) {
        for (Word bw: badWordsArray) {

            if (w.isBadWord(bw)) {
                return Word.censor(w);
            }
        }

        return w.getText();
    }

    void addToBadWordsArray(Word w, int index){
        badWordsArray[index] = w;
    }


}
