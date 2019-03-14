/**
 * Name         : Keng Jun Xian
 * Matric. No   : A0167718R
 * PLab Acct.   :
 */

import java.util.*;


public class Ranking {

	private void run() {
		Scanner sc = new Scanner(System.in);
		List<Student> studentList1 = new ArrayList<>();
		List<Student> studentList2 = new ArrayList<>();

		// scanning total number of students
		sc.nextLine();

		while (sc.hasNext()) {
			String name = sc.next();
			int score = sc.nextInt();
			Student s = new Student(name, score);

			studentList1.add(s);
			studentList2.add(s);
			sc.nextLine();
		}

		// sorting by highest score to lowest
		studentList2.sort((s1, s2) -> s2.getScore() - s1.getScore());

		for (int i = 1; i < studentList2.size(); i++) {
			Student prevStudent = studentList2.get(i - 1);

			studentList2.get(i).setRank(prevStudent);
		}

		for(Student s: studentList1) {
			System.out.println(s);
		}
	}



	public static void main(String[] args) {
		Ranking newRanking = new Ranking();
		newRanking.run();
	}
}

class Student {
	static int maxRank = 1;
	String name;
	int score;
	int studentRank = 1;

	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	void setRank(Student prevStudent) {
		maxRank++;
		if (prevStudent.score == this.score) {
			this.studentRank = prevStudent.studentRank;
		} else {
			this.studentRank = maxRank;
		}

	}


	int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return name + " " + studentRank;
	}
}
