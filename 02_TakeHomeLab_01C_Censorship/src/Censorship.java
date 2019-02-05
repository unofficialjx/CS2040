/**
 * Name         : KENG JUN XIAN
 * Matric. No   : A0167718R
 * PLab Acct.   :
 */

import java.util.*;

public class Censorship {
    public void run() {
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
