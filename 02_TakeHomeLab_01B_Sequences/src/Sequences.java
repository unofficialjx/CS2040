/**
 * Name         : Keng Jun Xian
 * Matric. No   : A0167718R
 * PLab Acct.   :
 */

import java.util.*;

public class Sequences {
	private void run() {
		AbstractSequence sequence;
		int sequenceSize;
		int typeOfSequence;
		long firstNumber;
		long ratio;
		Scanner sc = new Scanner(System.in);

		sequenceSize = sc.nextInt();
		sc.nextLine();

		typeOfSequence = sc.nextInt();
		sc.nextLine();

		firstNumber = sc.nextLong();
		ratio = sc.nextLong();

		if (typeOfSequence == 1) {
			sequence = new ArithmeticSequence(sequenceSize, firstNumber, ratio);
		} else {
			sequence = new GeometricSequence(sequenceSize, firstNumber, ratio);
		}

		for (int term = 1; term <= sequenceSize; term++) {
			sequence.calculateAndAppendToSequenceArray(term);
		}
		sequence.printSequence();







	}

	public static void main(String[] args) {
		Sequences newSequences = new Sequences();
		newSequences.run();
	}
}
