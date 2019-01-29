/**
 * Name         : KENG JUN XIAN
 * Matric. No   : A0167718R
 * PLab Acct.   :
 */

import java.util.*;

public class Censorship {
	private void run() {
		ArrayList<Word> story = new ArrayList<Word>();
		BadWords bws;
		int numOfBadWords;
		Scanner sc = new Scanner(System.in);

		numOfBadWords = sc.nextInt();
		bws = new BadWords(numOfBadWords);
		sc.nextLine();



		for (int i = 0; i < numOfBadWords; i++) {
			String badWordText = sc.next();
			Word bw = new Word(badWordText);
			bws.addToBadWordsArray(bw, i);
		}
		sc.nextLine();


		while (sc.hasNext()) {
			String wordText = sc.next();
			Word storyWords = new Word(wordText);
			story.add(storyWords);
		}

		WordList wl = new WordList(story);
		wl.printCensoredStory(bws);

	}


	public static void main(String[] args) {
		Censorship newCensorship = new Censorship();
		newCensorship.run();
	}
}
