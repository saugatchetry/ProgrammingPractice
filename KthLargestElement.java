import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5,6,7,8,9,10};
        int k = 9; // 7 should be the answer
        int result = findKthLargestElement(data,k);
        System.out.println(result);
    }

    private static int findKthLargestElement(int[] data, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : data){
            if(pq.size() < k){
                pq.add(i);
            }
            else{
                int temp = pq.peek();
                if(i > temp){
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        return pq.peek();
    }
}
