public class PowerFunction {
    public static void main(String[] args) {
        int n = 2;
        int k = 2;

        int result = powerOf(n,k);
        if(k % 2 != 0){
            result = result * n;
        }
        System.out.println(result);
    }

    private static int powerOf(int n, int k) {
        if(k == 0)
            return 1;
        if(k == 1)
            return n;

        int temp = powerOf(n,k/2);
        return temp*temp;

    }
}
