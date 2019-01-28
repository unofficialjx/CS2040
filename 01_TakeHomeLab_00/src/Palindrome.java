/*
 * author		: [Keng Jun Xian]
 * matric no.	: [A0167718R]
 */


import java.util.*;

public class Palindrome {
	/* use this method to check whether the string is palindrome word or not
	 * 		PRE-Condition  :
	 * 		POST-Condition :
	 */
	public static boolean isPalindrome(String word) {
		int numLetters = word.length();
		char[] arr = word.toCharArray();
		int j = numLetters - 1;

		for (int i = 0; i < (numLetters / 2); i++) {
			if (  arr[i] != arr[j] ) {
				return false;
			}
			j--;
		}

		return true;
	}
	
	public static void main(String[] args) {
		// declare the necessary variables
		String s1;
		String s2;
		String word;

		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
		s1 = sc.nextLine();
		s2 = sc.nextLine();

		// simulate the problem
		word = s1.concat(s2);
		boolean b = isPalindrome(word);

		// output the result
		if (b) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}
}