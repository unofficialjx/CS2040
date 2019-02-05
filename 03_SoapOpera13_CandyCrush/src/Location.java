public class Location {
    private int row;
    private int col;
    private long value;

    public Location(int row, int col, long value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }


    public Location[] getAllAdjacent(Location specialCandy, long [][] grid, int numRows, int numCols ) {
        Location[] locations = new Location[8];

        locations[0] = getLeft(specialCandy, grid, numRows, numCols);
        locations[1] = getDiagonalLowerLeft(specialCandy, grid, numRows, numCols);
        locations[2] = getDiagonalUpperLeft(specialCandy, grid, numRows, numCols);

        locations[3] = getRight(specialCandy, grid, numRows, numCols);
        locations[4] = getDiagonalLowerRight(specialCandy, grid, numRows, numCols);
        locations[5] = getDiagonalUpperRight(specialCandy, grid, numRows, numCols);

        locations[6] = getAbove(specialCandy, grid, numRows, numCols);
        locations[7] = getBelow(specialCandy, grid, numRows, numCols);

        return locations;
    }

    private Location getLeft(Location specialCandy, long [][] grid, int numRows, int numCols ) {
        if (specialCandy.col == 0) {
            return null;
        } else {
            this.row = specialCandy.row;
            this.col = specialCandy.col - 1;
            this.value = grid[row][col];

            return new Location(row, col, value);
        }
    }


    private Location getDiagonalUpperLeft(Location specialCandy, long [][] grid, int numRows, int numCols ) {
        if (specialCandy.col == 0 || specialCandy.row == 0) {
            return null;
        } else {
            this.row = specialCandy.row - 1;
            this.col = specialCandy.col - 1;
            this.value = grid[row][col];

            return new Location(row, col, value);
        }
    }

    private Location getDiagonalLowerLeft(Location specialCandy, long [][] grid, int numRows, int numCols ) {
        if (specialCandy.col == 0 || specialCandy.row == numRows - 1) {
            return null;
        } else {
            this.row = specialCandy.row + 1;
            this.col = specialCandy.col -1 ;
            this.value = grid[row][col];

            return new Location(row, col, value);
        }
    }


    private Location getRight(Location specialCandy, long [][] grid, int numRows, int numCols) {
        if (specialCandy.col == numCols - 1) {
            return null;
        } else {
            this.row = specialCandy.row;
            this.col = specialCandy.col + 1;
            this.value = grid[row][col];

            return new Location(row, col, value);
        }
    }

    private Location getDiagonalUpperRight(Location specialCandy, long [][] grid, int numRows, int numCols) {
        if (specialCandy.col == numCols - 1 || specialCandy.row == 0) {
            return null;
        } else {
            this.row = specialCandy.row - 1;
            this.col = specialCandy.col + 1;
            this.value = grid[row][col];

            return new Location(row, col, value);
        }
    }

    private Location getDiagonalLowerRight(Location specialCandy, long [][] grid, int numRows, int numCols) {
        if (specialCandy.col == numCols - 1 || specialCandy.row == numRows - 1) {
            return null;
        } else {
            this.row = specialCandy.row + 1;
            this.col = specialCandy.col + 1;
            this.value = grid[row][col];

            return new Location(row, col, value);
        }
    }

    private Location getAbove(Location specialCandy, long [][] grid, int numRows, int numCols) {
        if (specialCandy.row == 0) {
            return null;
        } else {
            this.row = specialCandy.row - 1;
            this.col = specialCandy.col;
            this.value = grid[row][col];

            return new Location(row, col, value);
        }
    }


    private Location getBelow(Location specialCandy, long [][] grid, int numRows, int numCols) {
        if (specialCandy.row == numRows - 1) {
            return null;
        } else {
            this.row = specialCandy.row + 1;
            this.col = specialCandy.col;
            this.value = grid[row][col];

            return new Location(row, col, value);
        }
    }

    public long getValue() {
        return value;
    }
}
