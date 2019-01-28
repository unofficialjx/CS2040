/**
 *
 * author	: [KENG JUN XIAN]
 * matric no: [A0167718R]
 * 
 */

import java.util.*;

public class StringComparison {
	
	public static void main(String[] args) {

		// declare the necessary variables
		String s1;
		String s2;

		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
		s1 = sc.nextLine();
		s2 = sc.nextLine();

		System.out.println(StringComparison.compare(s1, s2));

	}


	public static int compare(String s1, String s2) {
		int value = s1.compareToIgnoreCase(s2);


		if (value > 0) {
			value = 2;
		} else if (value < 0) {
			value = 1;
		}

		return value;
	}
}
