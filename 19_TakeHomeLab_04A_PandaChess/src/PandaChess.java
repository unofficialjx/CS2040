/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class PandaChess {
	ArrayList < ArrayList<Integer> > adjList = new ArrayList<>();


	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();

		// vertices start from 1
		for (int i = 0; i < N; i++) {
			adjList.add(new ArrayList<>());
		}

		while (sc.hasNext()) {
			int winner = sc.nextInt();
			int loser = sc.nextInt();
			adjList.get(winner).add(loser);
			sc.nextLine();
		}





	}


	public void khansAlgoBFS(int numVertices) {
		int[] indeg = new int[numVertices];
		int[] predecessorArray = new int[numVertices];
		Arrays.fill(predecessorArray, -1);
	}

	public static void main(String[] args) {
		PandaChess newPandaChess = new PandaChess();
		newPandaChess.run();
	}
}