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

		// vertices start from 1
		adjList.add(null);
		for (int i = 1; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}

		while (sc.hasNext()) {
			int winner = sc.nextInt();
			int loser = sc.nextInt();
			adjList.get(winner).add(loser);

		}

		khansAlgoBFS(N);

	}


	public void khansAlgoBFS(int numVertices) {
		Boolean uniqueOrdering = true;
		ArrayList<Integer> topoSortList = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();
		int[] indeg = new int[numVertices + 1];
		indeg[0] = -1;
		int[] predecessorArray = new int[numVertices + 1];
		Arrays.fill(predecessorArray, -1);

		for (ArrayList<Integer> listOfNeighbours : adjList) {
			if (listOfNeighbours == null) continue;
			for (int j = 0; j < listOfNeighbours.size(); j++) { // all neighbours of u (V)
				int v = listOfNeighbours.get(j);
				indeg[v]++;
			}
		}

		// enqueue vertices with indeg = 0
		// if initial number of vertices with indeg 0 is more than 1, multiple components.
		int numInitialIndeg0Vertices = 0;
		for (int v = 1; v < indeg.length; v++) {
			if (indeg[v] == 0) {
				q.offer(v);
				numInitialIndeg0Vertices++;
			}
		}
		if (numInitialIndeg0Vertices > 1) uniqueOrdering = false;

		while (!q.isEmpty()) {
			// vertexU is winner
			int vertexU = q.poll();
			topoSortList.add(vertexU);
			int numNeighboursOffered = 0;
			for (int loser : adjList.get(vertexU)) {
				if(indeg[loser] > 0) {
					indeg[loser]--; // because you removed U, so now your V (loser) has one less indeg
				}

				if (indeg[loser] == 0) {
					predecessorArray[loser] = vertexU;
					q.offer(loser);
					numNeighboursOffered++;
				}

				if (numNeighboursOffered > 1) uniqueOrdering = false;
			}
		}

		if (topoSortList.size() != numVertices) {
			System.out.println("No possible ranking.");
		} else if (!uniqueOrdering) {
			System.out.println("Ranking is not unique.");
		} else {
			for (int winner : topoSortList) {
				System.out.println(winner);
			}
		}
	}

	public static void main(String[] args) {
		PandaChess newPandaChess = new PandaChess();
		newPandaChess.run();
	}
}