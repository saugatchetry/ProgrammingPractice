public class AllSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6};
        int k = 3;
        printAllSubArrayOfK(input,k);
    }

    private static void printAllSubArrayOfK(int[] input,int k) {
        int temp = k;
        for(int i = 0; i <= input.length - k; i++){
            int j = i;
            while(temp > 0){
                System.out.print(input[j]+" ");
                j++;
                temp--;
            }
            temp = k;
            System.out.println();
        }
    }
}
