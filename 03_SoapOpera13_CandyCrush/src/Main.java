import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int numRows = sc.nextInt();
        final int numCols = sc.nextInt();
        sc.nextLine();


        long[][] grid = new long[numRows][numCols];
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                grid[i][j] = sc.nextLong();
            }
        }

        Location specialCandy = findSpecialCandy(grid, numRows, numCols);
        Location[] allAdjacent = specialCandy.getAllAdjacent(specialCandy, grid, numRows, numCols);
        Frequency f = new Frequency(grid, allAdjacent);
        int output = f.maxFrequencyOfHashMap() + 1;

        System.out.println(output);
    }


    public static Location findSpecialCandy(long[][] grid, int numRows, int numCols) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == -1) {
                    return new Location(i, j, -1);
                }
            }
        }
        return null;
    }
}
