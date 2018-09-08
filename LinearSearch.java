//Given an 1-D-array, search for a given number
public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,3,6,7,8,9};
        int search = 19;
        int searchIndexIterative = linearSearchIterative(nums,search);
        System.out.println("Found at "+searchIndexIterative);

        int currentPosition = 0;
        int searchIndexRecusive = linearSearchRecursive(nums,search,currentPosition);
        System.out.println("Recursively Found At "+searchIndexRecusive);
    }

    private static int linearSearchRecursive(int[] nums, int search, int currentPosition) {
        if(currentPosition == nums.length){
            return -1;
        }

        if(nums[currentPosition] == search){
            return currentPosition;
        }

        int result = linearSearchRecursive(nums,search,currentPosition+1);
        if(result > -1){
            return result;
        }
        else{
            return -1;
        }
    }

    private static int linearSearchIterative(int[] nums, int search) {
        if(nums.length <= 0){
            return -1;
        }
        else{
                for(int i = 0; i < nums.length; i++){
                    if(nums[i] == search){
                        return i;
                    }
                }

        }
        return -1;
    }

}
