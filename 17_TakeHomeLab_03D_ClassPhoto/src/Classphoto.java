/*
 * Name       :Keng Jun Xian
 * Matric No. :A0167718R
 * Plab Acct. :
 */
import java.util.*;

public class Classphoto {
	static int arrivalCounter = 0;

	class Student implements Comparable<Student> {
		int height;
		String name;
		int arrivalOrder;

		public Student(String name, int height) {
			this.name = name;
			this.height = height;
			this.arrivalOrder = arrivalCounter++;
		}

		@Override
		public int compareTo(Student other) {
				if (this.height != other.height) {
					// Compare by increasing height.
					return this.height - other.height;
				} else {
					// Compare by decreasing arrival.
					return other.arrivalOrder
							- this.arrivalOrder;
				}
			}

		@Override
		public String toString() {
			return this.name;
		}
	}


	private void run() {
		Scanner sc = new Scanner(System.in);
		TreeSet<Student> studentTree = new TreeSet<>();
		studentTree.add(new Student("Rar", 0));

		int N = sc.nextInt();
		sc.nextLine();

		while (sc.hasNext()) {
			String name = sc.next();
			int height = sc.nextInt();
			Student s = new Student(name, height);
			studentTree.add(s);
			System.out.println(studentTree.lower(s));
		}

		boolean isFirstStudent = true;
		for (Student s: studentTree) {
			if (isFirstStudent) {
				System.out.print(s);
				isFirstStudent = false;
			} else System.out.print(" " + s);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Classphoto newClassphoto = new Classphoto();
		newClassphoto.run();
	}
}