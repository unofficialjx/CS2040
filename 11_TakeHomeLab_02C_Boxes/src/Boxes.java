/**
 * Name         :Keng Jun Xian
 * Matric. No   :A0167718R
 * PLab Acct.   :
 */

import java.util.*;

public class Boxes {

	private class Cat {
		int x;
		int y;

		public Cat(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Cat cat = (Cat) o;
			return x == cat.x &&
					y == cat.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	Scanner sc = new Scanner(System.in);
	HashSet<Cat> cats = new HashSet<>();
	HashSet<Integer> rows = new HashSet<>();
	HashSet<Integer> cols = new HashSet<>();


	private void run() {
		int numOperations = sc.nextInt();
		int numRows = sc.nextInt();
		int numCols = sc.nextInt();
		sc.nextLine();

		while (sc.hasNext()) {
			String operation = sc.next();
			int x = -1;
			int y = -1;
			switch (operation) {
				case "SIT":
					x = sc.nextInt();
					y = sc.nextInt();
					sit(x,y);
					break;
				case "BOX":
					x = sc.nextInt();
					y = sc.nextInt();
					catInBox(x,y);
					break;
				case "ROW":
					x = sc.nextInt();
					catInRow(x);
					break;
				case "COL":
					y = sc.nextInt();
					catInCol(y);
					break;
			}
			sc.nextLine();
		}
	}

	private void sit(int x, int y) {
		Cat c = new Cat(x, y);
		cats.add(c);
		rows.add(c.x);
		cols.add(c.y);
	}

	private void catInBox(int x, int y) {
		Cat c = new Cat(x, y);
		boolean catIsPresent = cats.contains(c);
		if (catIsPresent) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
	}

	private void catInRow(int x) {
		boolean catIsPresent = rows.contains(x);
		if (catIsPresent) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
	}

	private void catInCol(int y) {
		boolean catIsPresent = cols.contains(y);
		if (catIsPresent) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
	}


	public static void main(String[] args) {
		Boxes newBoxes = new Boxes();
		newBoxes.run();
	}
}
