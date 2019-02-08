public class Word {
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
