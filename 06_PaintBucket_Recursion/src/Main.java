public class Main {

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {

            for (int col : row) {
                System.out.print(col + " ");

            } // not particular about extra trailing space here System.out.println();
        }
    }

    public static void main(String[] args) { int[][] colourMatrix = {

            {1,1,1,1,2,2,2,1},
            {1,1,1,0,0,0,0,2},
            {2,1,0,0,0,0,2,2},

            {1,0,0,0,0,0,2,2},
            {2,0,0,2,2,2,1,1},
            {2,0,0,2,2,0,0,0},
            {1,1,1,0,0,0,0,0},

            {0,0,0,0,0,0,0,2}
    };

        System.out.println("Before fill..."); printMatrix(colourMatrix); System.out.println();

        paintBucketFill(colourMatrix, 2, 3, 2);
        /* TODO : Implement that */
        System.out.println("After fill..."); printMatrix(colourMatrix);

    }

    public static void paintBucketFill(int[][] matrix, int row, int col, int newColour) {
        int initialColour = matrix[row][col];

        if (newColour != initialColour) {
            paintBucketFill(matrix, row, col, newColour, matrix[row][col]);
        }

    }

    public static void paintBucketFill(int[][] matrix, int row, int col, int newColour, int initialColour) {

        if (row < 0 ||  row >= matrix.length ||
                col < 0 || col >= matrix[0].length
                || initialColour != matrix[row][col]) {
            return;
        }

        matrix[row][col] = newColour;
        paintBucketFill(matrix, row - 1, col, newColour, initialColour);
        paintBucketFill(matrix, row, col - 1, newColour, initialColour);
        paintBucketFill(matrix, row + 1, col, newColour, initialColour);
        paintBucketFill(matrix, row, col + 1, newColour, initialColour);

    }
}
