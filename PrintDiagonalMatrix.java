public class PrintDiagonalMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   2,   3,  4},
                {5,   6,   7,  8},
                {9,  10,  11,  12},
                {13, 14,  15,  16}
        };

        printDiagonal(matrix);
    }

    private static void printDiagonal(int[][] matrix) {
        int rows = matrix.length - 1;
        int columns = matrix[0].length - 1;

        for(int k = 0; k <= rows; k++){
            int j = 0;
            int i = k;
            while(i >= 0){
                System.out.print(matrix[i][j]+" ");
                i--;
                j++;
            }
            System.out.println();
        }

        for(int k = 1; k <= columns; k++){
            int i = rows;
            int j = k;
            while(j <= columns){
                System.out.print(matrix[i][j]+" ");
                i--;
                j++;
            }
            System.out.println();
        }

    }
}
