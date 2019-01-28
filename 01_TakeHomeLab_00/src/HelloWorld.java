/**
 *
 * author	: []
 * matric no: []
 * 
 */

import java.util.*;

public class HelloWorld {

	public static void main(String[] args) {

		// declare the necessary variables
		int inputType;
		ArrayList<Byte> output;

		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);


		// read input and process them accordingly
		inputType = sc.nextInt();

		if (inputType == 1) {
			output = inputMethod1(sc);
		} else if (inputType == 2) {
			output = inputMethod2(sc);
		} else {
			output = inputMethod3(sc);
		}

		printOutput(output);
	}

	private static ArrayList<Byte> inputMethod1(Scanner sc) {
		int totalQueries;
		int numQueriesProcessed = 0;
		ArrayList<Byte> outputList = new ArrayList<>();


		totalQueries = sc.nextInt();
		sc.nextLine();

		while (numQueriesProcessed < totalQueries) {
			scanAndAddOutputToList(sc, outputList);
			numQueriesProcessed++;
		}

		return outputList;
	}

	private static ArrayList<Byte> inputMethod3(Scanner sc) {
		ArrayList<Byte> outputList = new ArrayList<>();
		sc.nextLine();
		while (sc.hasNext()) {
			scanAndAddOutputToList(sc, outputList);
		}

		return outputList;
	}

	private static ArrayList<Byte> inputMethod2(Scanner sc) {
		ArrayList<Byte> outputList = new ArrayList<>();
		sc.nextLine();
		while ( true ) {
			String operator = sc.next();
			if (operator.equals("-1") || operator.equals("0")) break;
			byte firstBit = sc.nextByte();
			byte secondBit = sc.nextByte();

			byte output = querySolver(operator, firstBit, secondBit);
			outputList.add(output);
		}

		return outputList;
	}


	private static void printOutput(ArrayList<Byte> output) {
		output.forEach(System.out::println);
	}


	private static void scanAndAddOutputToList(Scanner sc, ArrayList<Byte> outputList) {
		String operator = sc.next();
		byte firstBit = sc.nextByte();
		byte secondBit = sc.nextByte();

		byte output = querySolver(operator, firstBit, secondBit);
		outputList.add(output);
	}


	 private static byte querySolver(String operator, byte firstBit, byte secondBit) {
		if (operator.equals("AND")) {
			if (firstBit == 1 && secondBit == 1) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (firstBit == 0 && secondBit == 0) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
