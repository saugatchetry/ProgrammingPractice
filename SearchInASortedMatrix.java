public class SearchInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,2,3},
                {4,5,6,7},
                {8,9,10,11},
                {12,13,14,15}
        };

        int search = 12;

        boolean result = findElement(matrix, search);
        System.out.println(result);
    }

    private static boolean findElement(int[][] matrix, int search) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int row = 0;
        int column = matrix[0].length - 1;

        while(row < matrix[0].length && column >= 0){
            if(matrix[row][column] == search){
                return true;
            }
            if(matrix[row][column] < search){
                row++;
            }
            else{
                column--;
            }
        }
        return false;
    }
}
