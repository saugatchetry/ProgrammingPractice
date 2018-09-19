public class EvaluateExpression {
    public static void main(String[] args) {
        String exp = "((1+3)+((1+2)*5))";
        int result = evaluate(exp);
        System.out.println("Result = "+result);
    }

    private static int evaluate(String exp) {
        int index = 0;
        return evaluateHelper(exp,index);
    }

    private static int evaluateHelper(String exp, int index) {
        char ch = exp.charAt(index);
        System.out.println("Ch = "+ch+" index = "+index);
        if(ch == '('){
            index++;                //move past (
            int left = evaluateHelper(exp,index);
            index++;
            //System.out.println("Left = "+left);

            char operator = exp.charAt(index);
            index++;                //move past operator
            //System.out.println("Operator = "+operator);

            int right = evaluateHelper(exp,index);
            index++;
            //System.out.println("Right = "+right);

            if(operator == '+'){
                return left + right;
            }
            else if(operator == '*'){
                return left * right;
            }
            else{
                return 0;
            }
        }
        else{
            index++;
            return ch - '0';
        }

    }
}
