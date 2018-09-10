import java.util.*;

public class AllSubSequenceofSizeK {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6};
        int k = 3;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int startIndex = 0;
        printAllSubsequencesOfSizeK(input,k,temp,result,startIndex);

        for(List<Integer> list : result){
            for (Integer i : list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    private static void printAllSubsequencesOfSizeK(int[] input, int k, List<Integer> temp, List<List<Integer>> result, int startIndex) {

        if(temp.size() == k) {
            result.add(new ArrayList<>(temp));
        }

        for(int i = startIndex; i < input.length; i++){
            temp.add(input[i]);
            printAllSubsequencesOfSizeK(input,k,temp,result, i+1);
            temp.remove(temp.size() - 1);
        }

    }
}
