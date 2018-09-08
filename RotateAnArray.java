public class RotateAnArray {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6,7};
        int k = 2;
        String direction = "right";
        rotateArray(input,k,direction);

    }

    private static void rotateArray(int[] input, int k,String direction) {
        if(direction.equalsIgnoreCase("left")) {
            while (k > 0) {
                int temp = input[0];
                for (int i = 1; i < input.length; i++) {
                    input[i - 1] = input[i];
                }
                input[input.length - 1] = temp;
                k--;
            }
            for (int i : input) {
                System.out.print(i + " ");
            }
        }
        else{
            while (k > 0) {
                int temp = input[input.length - 1];
                for (int i = input.length - 2; i >=0 ; i--) {
                    input[i + 1] = input[i];
                }
                input[0] = temp;
                k--;
            }
            for (int i : input) {
                System.out.print(i + " ");
            }

        }

    }
}
