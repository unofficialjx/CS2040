/*
 * Name       :Keng Jun Xian
 * Matric No. :A0167718R
 * Plab Acct. :
 */
import java.util.*;

public class OldHeight {
    final int MAX_VERTICES = 100000;
    ArrayList< ArrayList<IntegerDouble> > adjList = new ArrayList<>();

    class IntegerDouble implements Comparable<IntegerDouble> {
        Integer neighbour, weight;


        public IntegerDouble(Integer neighbour, Integer weight) {
            this.neighbour = neighbour;
            this.weight = weight;
        }

        @Override
        public int compareTo(IntegerDouble o) {
            return Comparator.comparing(IntegerDouble::getNeighbour)
                    .thenComparing(IntegerDouble::getWeight)
                    .compare(this, o);
        }

        public Integer getNeighbour() {
            return neighbour;
        }
        public Integer getWeight() {
            return weight;
        }
    }


    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < MAX_VERTICES; i++) {
            adjList.add(null);
        }

        for (int count = 0; count < N - 1; count++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int weight = sc.nextInt();
            IntegerDouble neighbourAndWeight = new IntegerDouble(y, weight);

            if (adjList.get(x) == null) {
                ArrayList<IntegerDouble> listForVertexX = new ArrayList<>();
                listForVertexX.add(neighbourAndWeight);
            } else {
                adjList.get(x).add(neighbourAndWeight);
            }

            sc.nextLine();
        }

        int numQueries = sc.nextInt();
        sc.nextLine();

        while (sc.hasNext()) {

        }
    }


    private HashSet<Integer> bfs(int sourceVertex, int endingVertex) {
        HashSet<Integer> verticesVisited = new HashSet<>();
        Queue<Integer> verticesAtCurrentLevel = new ArrayDeque<>();

        verticesAtCurrentLevel.offer(sourceVertex);
        verticesVisited.add(sourceVertex);

        while (!verticesAtCurrentLevel.isEmpty()) {
            int currentlyVisiting = verticesAtCurrentLevel.poll();

            ArrayList<IntegerDouble> neighboursAndWeights = adjList.get(currentlyVisiting);

            for (IntegerDouble pair : neighboursAndWeights) {
                int neighbour = pair.getNeighbour();

                verticesVisited.add(neighbour);
                verticesAtCurrentLevel.offer(neighbour);
            }
        }

        return verticesVisited;
    }

    boolean pathExists(int sourceVertex, int endingVertex) {
        HashSet<Integer> verticesVisited = bfs(sourceVertex, endingVertex);
        return (verticesVisited.contains(endingVertex));
    }

    int heightDifference(int sourceVertex, int endingVertex) {
        ArrayList<IntegerDouble> neighboursAndWeightsForSource = adjList.get(sourceVertex);
        ArrayList<IntegerDouble> neighboursAndWeightsForEnd = adjList.get(endingVertex);

        Collections.sort(neighboursAndWeightsForSource);
        Collections.sort(neighboursAndWeightsForEnd);

        int s = 0;
        int e = 0;

        while (s < neighboursAndWeightsForSource.size() &&
                e < neighboursAndWeightsForEnd.size() &&
                !neighboursAndWeightsForSource.get(s).getNeighbour().equals(
                        neighboursAndWeightsForEnd.get(e).getNeighbour() ) ) {

            if (neighboursAndWeightsForSource.get(s).getNeighbour() <  neighboursAndWeightsForEnd.get(e).getNeighbour()) {
                s++;
            } else {
                e++;
            }
        }

        int commonNeighbour = neighboursAndWeightsForEnd.get(e).getNeighbour();

        int heightDiffBetweenSourceAndNeighbour =
                neighboursAndWeightsForSource.get(commonNeighbour).getWeight();

        int heightDiffBetweenEndAndNeighbour =
                neighboursAndWeightsForEnd.get(commonNeighbour).getWeight();

        return  heightDiffBetweenEndAndNeighbour - heightDiffBetweenSourceAndNeighbour;
    }

    public static void main(String[] args) {
        OldHeight newOldHeight = new OldHeight();
        newOldHeight.run();
    }
}
