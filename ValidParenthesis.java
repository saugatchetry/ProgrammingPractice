import java.util.ArrayList;
import java.util.List;

public class ValidParenthesis {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<>();
        String temp = "";
        int open = 0, close = 0;
        validParenthesis(result,temp,n,open,close);

        for(String r : result){
            System.out.println(r);
        }
    }

    private static void validParenthesis(List<String> result, String temp, int n, int open, int close) {

        if(close == n){
            result.add(temp);
            return;
        }

        else {
            if (open < n) {
                validParenthesis(result, temp+"(", n, open + 1, close);
            }

            if (open > close) {
                validParenthesis(result, temp + ")", n, open, close + 1);
            }
        }
    }
}
