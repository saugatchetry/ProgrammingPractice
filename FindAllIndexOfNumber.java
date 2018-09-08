import java.util.ArrayList;
import java.util.List;

public class FindAllIndexOfNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,1,6,5,3,2,1,3,4,5};
        int search = 12;
        List<Integer> result = findAllIndexesIterative(nums,search);
        for(Integer i : result){
            System.out.print(i + ",");
        }
        System.out.println();

        ArrayList<Integer> resultRecursive = new ArrayList<>();
        int currentPosition = 0;
        result = findAllIndexesRecursive(nums,resultRecursive,search,currentPosition);

        System.out.println("Recursively");
        for(Integer i : result){
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private static List<Integer> findAllIndexesRecursive(int[] nums, ArrayList<Integer> resultRecursive, int search, int currentPosition) {
        if(currentPosition == nums.length){
            return resultRecursive;
        }

        if(nums[currentPosition] == search){
            resultRecursive.add(currentPosition);

        }
        findAllIndexesRecursive(nums,resultRecursive,search,currentPosition + 1);
        return resultRecursive;
    }

    private static ArrayList<Integer> findAllIndexesIterative(int[] nums, int search) {
        ArrayList<Integer> result = new ArrayList<>();
        if(nums.length < 0){
            result.add(-1);
            return result;
        }
        else{
            for(int i = 0; i < nums.length;i++){
                if(nums[i] == search){
                    result.add(i);
                }
            }
        }
        return result;
    }

}
