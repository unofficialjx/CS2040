import java.util.*;
/*
 * Name       :Keng Jun Xian
 * Matric No. :A0167718R
 * Plab Acct. :
 */

public class OldHeight1 {
        final int MAX_VERTICES = 100000;
        ArrayList<ArrayList<IntegerPair>> adjList = new ArrayList<>();

        class IntegerPair implements Comparable<IntegerPair> {
            Integer neighbour, weight;

            public IntegerPair(Integer neighbour, Integer weight) {
                this.neighbour = neighbour;
                this.weight = weight;
            }

            @Override
            public int compareTo(IntegerPair o) {
                return Comparator.comparing(IntegerPair::getNeighbour)
                        .thenComparing(IntegerPair::getWeight)
                        .compare(this, o);
            }

            public Integer getNeighbour() {
                return neighbour;
            }
            public Integer getWeight() {
                return weight;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                IntegerPair that = (IntegerPair) o;
                return Objects.equals(neighbour, that.neighbour);
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
                IntegerPair neighbourAndWeightForX = new IntegerPair(y, weight);
                IntegerPair neighbourAndWeightForY = new IntegerPair(x, weight * -1);

                if (adjList.get(x) == null) {
                    ArrayList<IntegerPair> listForVertexX = new ArrayList<>();
                    listForVertexX.add(neighbourAndWeightForX);
                } else {
                    adjList.get(x).add(neighbourAndWeightForX);
                }

                if (adjList.get(y) == null) {
                    ArrayList<IntegerPair> listForVertexY = new ArrayList<>();
                    listForVertexY.add(neighbourAndWeightForY);
                } else {
                    adjList.get(y).add(neighbourAndWeightForY);
                }

                sc.nextLine();
            }

            int numQueries = sc.nextInt();
            sc.nextLine();

            while (sc.hasNext()) {
                int sourceVertex = sc.nextInt();
                int endingVertex = sc.nextInt();
                System.out.println( getHeightDifference(sourceVertex, endingVertex) );
                sc.nextLine();
            }
        }


        private HashMap<Integer, Integer> bfs(int sourceVertex) {
            HashMap<Integer, Integer> verticesVisited = new HashMap<>();
            Queue<Integer> verticesAtCurrentLevel = new ArrayDeque<>();

            verticesAtCurrentLevel.offer(sourceVertex);
            verticesVisited.put(sourceVertex, -1);

            while (!verticesAtCurrentLevel.isEmpty()) {
                int currentlyVisiting = verticesAtCurrentLevel.poll();

                ArrayList<IntegerPair> neighboursAndWeights = adjList.get(currentlyVisiting);

                for (IntegerPair pair : neighboursAndWeights) {
                    int neighbour = pair.getNeighbour();

                    verticesVisited.put(neighbour, currentlyVisiting);
                    verticesAtCurrentLevel.offer(neighbour);
                }
            }

            return verticesVisited;
        }

        private int getHeightDifference(int sourceVertex, int endingVertex) {
            HashMap<Integer, Integer> path = bfs(sourceVertex);
            int heightDifference = 0;

            int currentKey = endingVertex;

            while (currentKey != sourceVertex) {
                int predecessor = path.get(currentKey);

                int index = adjList.get(currentKey).indexOf(new IntegerPair(predecessor, -1));
                IntegerPair predecessorAndWeight = adjList.get(currentKey).get(index);

                heightDifference += predecessorAndWeight.weight;
                currentKey = predecessor;

            }

            return heightDifference;
        }



        public static void main(String[] args) {
            OldHeight1 newHeight = new OldHeight1 ();
            newHeight.run();
        }
    }

