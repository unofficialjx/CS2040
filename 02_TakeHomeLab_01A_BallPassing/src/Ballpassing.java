/**
 * Name         : Keng Jun Xian
 * Matric. No   : A0167718R
 * PLab Acct.   :
 */

import java.util.*;

public class Ballpassing {
	private List<String> circle = new LinkedList<String>();
	private ListIterator<String> iterator;
	private String currentStudent;

	String next() {
		if ( ! iterator.hasNext()) {
			iterator = circle.listIterator();
		}

		currentStudent = iterator.next();

		return currentStudent;
	}

	void join(String arrival) {
		iterator.add(arrival);
		currentStudent = arrival;
	}

	void leave() {
		if (iterator.hasPrevious()) {
			iterator.previous();
		} else {
			iterator.next();
		}
		iterator.remove();
		next();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int numStudents;
		int numEvents;
		int eventCount = 0;

		numStudents = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < numStudents; i++) {
			String student = sc.next();
			circle.add(student);
		}
		iterator = circle.listIterator();
		iterator.next();
		sc.nextLine();

		numEvents = sc.nextInt();

		while (eventCount < numEvents) {
			String event = sc.next();
			if (event.equals("NEXT")) {
				next();
			} else if (event.equals("JOIN")) {
				String arrival = sc.next();
				join(arrival);
			} else {
				leave();
			}

			System.out.println(currentStudent);
			eventCount++;
		}
	}

	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}

