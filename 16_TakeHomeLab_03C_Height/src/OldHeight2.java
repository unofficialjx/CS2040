/*
 * Name       :Keng Jun Xian
 * Matric No. :A0167718R
 * Plab Acct. :
 */
import java.util.*;

public class OldHeight2 {

    final int MAX_VERTICES = 100_000;
    ArrayList<ArrayList<IntegerPair>> adjList = new ArrayList<>();


    class IntegerPair implements Comparable<IntegerPair> {
        Integer y, weight;

        public IntegerPair(Integer neighbour, Integer weight) {
            this.y = neighbour;
            this.weight = weight;
        }

        @Override
        public int compareTo(IntegerPair o) {
            return Comparator.comparing(IntegerPair::getY)
                    .thenComparing(IntegerPair::getWeight)
                    .compare(this, o);
        }

        public Integer getY() {
            return y;
        }
        public Integer getWeight() {
            return weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntegerPair that = (IntegerPair) o;
            return Objects.equals(this.y, that.y);
        }
    }

    private void run() {

        adjList.add(null);
        // vertices start from 1
        for (int i = 1; i <= MAX_VERTICES; i++) {
            adjList.add(new ArrayList<>());
        }

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();


        for (int count = 1; count <= N - 1; count++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int weight = sc.nextInt() * -1;
            IntegerPair neighbourAndWeightForX = new IntegerPair(y, weight);
            IntegerPair neighbourAndWeightForY = new IntegerPair(x, weight * -1);

            adjList.get(x).add(neighbourAndWeightForX);
            adjList.get(y).add(neighbourAndWeightForY);

            sc.nextLine();
        }

        int numQueries = sc.nextInt();
        sc.nextLine();
        int queryCounter = 0;

        while (queryCounter < numQueries) {
            int sourceVertex = sc.nextInt();
            int endingVertex = sc.nextInt();
            System.out.println( getHeightDifference(sourceVertex, endingVertex) );

            queryCounter++;
        }

    }


    private HashMap<Integer, IntegerPair> bfs(int sourceVertex) {
        HashMap<Integer, IntegerPair> verticesVisitedMapToPredecessor = new HashMap<>();
        Queue<Integer> verticesAtCurrentLevel = new ArrayDeque<>();

        verticesAtCurrentLevel.offer(sourceVertex);
        verticesVisitedMapToPredecessor.put(sourceVertex, new IntegerPair(-1, null));

        while (!verticesAtCurrentLevel.isEmpty()) {
            int currentlyVisiting = verticesAtCurrentLevel.poll();

            ArrayList<IntegerPair> neighboursAndWeights = adjList.get(currentlyVisiting);

                for (IntegerPair pair : neighboursAndWeights) {
                    int neighbour = pair.getY();
                    int weight = pair.getWeight();

                    verticesVisitedMapToPredecessor.put(neighbour, new IntegerPair(currentlyVisiting, weight));
                    verticesAtCurrentLevel.offer(neighbour);
                }
        }

        return verticesVisitedMapToPredecessor;
    }

    private int getHeightDifference(int sourceVertex, int endingVertex) {
        HashMap<Integer, IntegerPair> path = bfs(sourceVertex);
        int heightDifference = 0;

        int currentKey = endingVertex;

        while (currentKey != sourceVertex) {
            IntegerPair predecessorAndWeight = path.get(currentKey);
            int predecessor = predecessorAndWeight.getY();
            int weight = predecessorAndWeight.getWeight();

            heightDifference += weight;

            // traversing backwards from endingVertex
            currentKey = predecessor;

        }
        return heightDifference;
    }


    public static void main(String[] args) {
        OldHeight2 newHeight = new OldHeight2();
        newHeight.run();
    }
}
