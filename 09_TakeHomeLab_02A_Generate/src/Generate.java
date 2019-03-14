/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Generate {
	Scanner sc = new Scanner(System.in);
	List<String> permutations = new ArrayList<>();
	List<String> subSequences = new ArrayList<>();

	private void run() {

		String inputString = sc.nextLine();

		permuteString("", inputString);
		addSubSequences(inputString, "");
		subSequences.remove("");
		Collections.sort(permutations);
		Collections.sort(subSequences);
		permutations.forEach(System.out::println);
		subSequences.forEach(System.out::println);

	}



	private void permuteString(String beginningString, String endingString) {
		if (endingString.length() <= 1) {
			permutations.add(beginningString + endingString);
		} else {
			for (int i = 0; i < endingString.length(); i++) {
				// I give you (e, ast) & (a, est), & (s, eat), & (t eas)
				// you permute for me
				String newString = endingString.substring(0,i) + endingString.substring(i+1);
				permuteString(beginningString + endingString.charAt(i), newString);
			}
		}
	}

	private void addSubSequences(String str, String temp) {
		if(str.length() == 0) {
			subSequences.add(temp);
		} else {
			addSubSequences(str.substring(1), temp + str.substring(0, 1));
			addSubSequences(str.substring(1), temp);
		}
	}

	/*
	// i generate my own substring, eg east will generate east, eas, ea & a.
	private void personalSubString(String inputString) {
		if (inputString.length() <= 1) {
			subSequences.add(inputString);
		} else {
			subSequences.add(inputString);
			String removedLastLetterString = inputString.substring(0, inputString.length() -1);
			personalSubString(removedLastLetterString);
		}
	}


	private void allSubStrings(String inputString) {
		if (inputString.length() <= 1) {
			personalSubString(inputString);
		} else {
			// i generate my own
			personalSubString(inputString);
			// ask mySubString to generate their own, ie east will ask ast to generate his own personal substrings
			allSubStrings(inputString.substring(1));
		}
	}
*/



	public static void main(String[] args) {
		Generate newGenerate = new Generate();
		newGenerate.run();
	}
}
