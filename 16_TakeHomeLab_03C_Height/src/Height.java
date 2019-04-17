/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class Height {

    class Edge {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }


    ArrayList< ArrayList<Edge> > adjList = new ArrayList<>();

    private void run() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        adjList.add(null);
        // vertices start from 1
        for (int i = 1; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int count = 1; count <= N - 1; count++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int weight = sc.nextInt() * -1;
            Edge neighbourAndWeightForX = new Edge(x, y, weight);
            Edge neighbourAndWeightForY = new Edge(y, x, weight * -1);

            adjList.get(x).add(neighbourAndWeightForX);
            adjList.get(y).add(neighbourAndWeightForY);
            sc.nextLine();
        }


        long[] distancesOfAllVerticesFrom1 = bfs(1, N);

        int numQueries = sc.nextInt();
        sc.nextLine();

        while (sc.hasNext()) {
            int sourceVertex = sc.nextInt();
            int endingVertex = sc.nextInt();


            // take source vertex to be 4 and ending vertex to be 7
            // 4 -> 1
            // 1 -> 7
            long sourceToEndDistance
                    = - distancesOfAllVerticesFrom1[sourceVertex] + distancesOfAllVerticesFrom1[endingVertex];

            System.out.println(-sourceToEndDistance);
            sc.nextLine();
        }
    }


    // this returns a distance array where every vertex[Y} is Y's distance from vertex X
    private long[] bfs(int x, int N) {
        long[] distance = new long[N+1];
        boolean[] isVisited = new boolean[N+1];
        // queue contains vertices of currentLevel and neighbours
        Queue<Integer> verticesAtCurrentLevel = new ArrayDeque<>();

        isVisited[x] = true;
        verticesAtCurrentLevel.offer(x);

        while ( !verticesAtCurrentLevel.isEmpty() ) {
            int current = verticesAtCurrentLevel.poll();
            ArrayList<Edge> allNeighbours = adjList.get(current);
            for (Edge e : allNeighbours) {
                int neighbour =  e.end;
                if ( !isVisited[neighbour] ) {
                    isVisited[neighbour] = true;
                    distance[neighbour] = distance[current] + e.weight;
                    verticesAtCurrentLevel.offer(neighbour);
                }
            }
        }

        return distance;
    }



    public static void main(String[] args) {
        Height newHeight = new Height();
        newHeight.run();
    }
}
