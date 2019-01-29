public class Word {
    private String text;
    private int wordLength;
    private boolean _isBadWord;

    public Word(String text) {
        this.text = text;
        this.wordLength = text.length();
        _isBadWord = false;
    }


     protected boolean isBadWord(Word badWord) {
        if (this.text.compareToIgnoreCase(badWord.text)  == 0) {
            _isBadWord = true;
            return _isBadWord;
        }

        return _isBadWord;
    }

    protected static String censor(Word badWord) {
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
