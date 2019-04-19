/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class Supplies {
    class DijkNode implements Comparable<DijkNode> {
        private int vertex;
        private int distEstimate;

        public DijkNode(int vertex, int distEstimate) {
            this.vertex = vertex;
            this.distEstimate = distEstimate;
        }

        public int compareTo(DijkNode other) {
            return this.distEstimate - other.distEstimate;
        }

        public int getVertex() {
            return vertex;
        }

        public int getDistEstimate() {
            return distEstimate;
        }
    }


    class Edge {
        int start, neighbour, weight;

        public Edge(int start, int neighbour, int weight) {
            this.start = start;
            this.neighbour = neighbour;
            this.weight = weight;
        }

        public int getNeighbour() {
            return neighbour;
        }

        public int getWeight() {
            return weight;
        }
    }

    ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();

    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        int H = sc.nextInt();
        int T = sc.nextInt();

        for (int v = 0; v < N; v++) {
            adjList.add(new ArrayList<>());
        }

        while (sc.hasNext()) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            adjList.get(A).add(new Edge(A, B, C));
        }

        final int INF = 1000000000;
        int[] distanceArrOne = new int[N];
        for (int i = 0; i < N; ++i) {
            distanceArrOne[i] = INF;
        }
        int distanceTo = dijkstrasAlgo(H, distanceArrOne, T);


        int[] distanceArrTwo = new int[N];
        for (int i = 0; i < N; ++i) {
            distanceArrTwo[i] = INF;
        }
        int distanceBack = dijkstrasAlgo(T, distanceArrTwo, H);


        if (distanceTo == INF || distanceBack == INF) System.out.println("-1");
        else System.out.println(distanceTo + distanceBack);
    }

    private int dijkstrasAlgo (int source, int[] distance, int destination) {
        PriorityQueue<DijkNode> dijkstraPQ = new PriorityQueue<>();
        distance[source] = 0;
        dijkstraPQ.add(new DijkNode(source, 0));

        while (!dijkstraPQ.isEmpty()) {
            DijkNode node = dijkstraPQ.poll();
            int vertex = node.getVertex();
            int distEst = node.getDistEstimate();

            if (distance[vertex] != distEst) {
                continue;
            }


            for (Edge edge : adjList.get(vertex)) {
                int nextVertex = edge.getNeighbour();
                int nextDistEst = distEst + edge.getWeight();

                // relaxation
                if (nextDistEst < distance[nextVertex]) {
                    distance[nextVertex] = nextDistEst;
                    dijkstraPQ.add(new DijkNode(nextVertex, nextDistEst));
                }
            }
        }
        return distance[destination];
    }

    public static void main(String[] args) {
        Supplies newSupplies = new Supplies();
        newSupplies.run();
    }
}
