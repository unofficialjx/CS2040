/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class PandaIslands {

   class Island {
       int islandNumber, area;
       String colour;

       public Island(int islandNumber, int area, String colour) {
           this.islandNumber = islandNumber;
           this.area = area;
           this.colour = colour;
       }

       public void setColour(String colour) {
           this.colour = colour;
       }
   }


   class Pair {
       int whiteArea = 0;
       int blackArea = 0;

       public int minArea() {
           if (whiteArea <= blackArea) return whiteArea;
           else return blackArea;
       }
   }


    ArrayList < ArrayList<Integer> > adjList = new ArrayList<>();
    ArrayList <Island> islandsList = new ArrayList<>();
    Pair p = new Pair();

    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();

        // settling island sizes
        islandsList.add(null);
        int currentIslandNumber = 1;
        while (currentIslandNumber <= N) {
            int area = sc.nextInt();
            islandsList.add(new Island(currentIslandNumber, area, "WHITE"));
            currentIslandNumber++;
        }

        // settling neighbours
        adjList.add(null);
        for (int v = 1; v <= N; v++) {
            adjList.add(new ArrayList<>());
        }

        int  edgesCount = 0;
        while (edgesCount < E) {
            int island = sc.nextInt();
            int neighbour = sc.nextInt();
            adjList.get(island).add(neighbour);
            adjList.get(neighbour).add(island);
            edgesCount++;
        }


        // initialization
        boolean[] visitedArr = new boolean[N + 1];
        Arrays.fill(visitedArr, false);
        int[] predecessorArr = new int[N + 1];
        Arrays.fill(predecessorArr, -1);


        // DFS
        int minArea = DFS(visitedArr, predecessorArr, N);
        System.out.println(minArea);
    }

    // this will be the DFS spanning tree for 1 component
    private void DFSrec(int v,
                        boolean[] visitedArr, int[] predecessorArr) {

        visitedArr[v] = true;
        if (islandsList.get(v).colour.equals("WHITE")) {
            p.whiteArea += islandsList.get(v).area;
        } else {
            p.blackArea += islandsList.get(v).area;
        }

        for (int neighbour : adjList.get(v)) {
            if (!visitedArr[neighbour]) {
                predecessorArr[neighbour] = v;

                if (islandsList.get(v).colour.equals("WHITE")) {
                    islandsList.get(neighbour).setColour("BLACK");
                } else {
                    islandsList.get(neighbour).setColour("WHITE");
                }

                DFSrec(neighbour, visitedArr, predecessorArr);
            }
        }
    }


    // covers all components
    private int DFS(boolean[] visitedArr, int[] predecessorArr, int numIslands){
        int minArea = 0;
        for (int v = 1; v <= numIslands; v++) {
            if ( !visitedArr[v] ) {
                DFSrec(v, visitedArr, predecessorArr);
                int minAreaOfComponent = p.minArea();
                minArea += minAreaOfComponent;
                p = new Pair();
            }
        }
        return minArea;
    }


    public static void main(String[] args) {
        PandaIslands newPandaIslands = new PandaIslands();
        newPandaIslands.run();
    }
}
