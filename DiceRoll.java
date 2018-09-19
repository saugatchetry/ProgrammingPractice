import java.util.ArrayList;
import java.util.List;

public class DiceRoll {
    public static int count = 0;
    public static void main(String[] args) {

        int numberOfDice = 2;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        printAllCombinations(numberOfDice,result,temp);
        //System.out.println("Size = "+result.size());
//        for(List<Integer> list : result){
//            for(Integer i : list){
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }

        int desiredSum = 7;
        List<List<Integer>> resultSum = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();
        int sumSoFar = 0;

        //diceRollWithSum(numberOfDice, resultSum, chosen, desiredSum, sumSoFar);

        diceRollWithSum1(numberOfDice,resultSum,chosen,desiredSum);
        for(List<Integer> list : resultSum){
            for(Integer i : list){
                System.out.print(i+" ");
            }
            System.out.println();
        }


    }

    private static void diceRollWithSum(int numberOfDice, List<List<Integer>> resultSum, List<Integer> chosen, int desiredSum, int sumSoFar) {

        if(numberOfDice == 0){
            if(sumSoFar == desiredSum){
                resultSum.add(new ArrayList<>(chosen));
            }
        }

        else {
            for(int i = 1; i <= 6; i++){
                if((sumSoFar + i + (numberOfDice - 1)*1 <= desiredSum) && (sumSoFar + i + (numberOfDice - 1) * 6 >= desiredSum)){
                    chosen.add(i);
                    diceRollWithSum(numberOfDice - 1,resultSum,chosen,desiredSum, sumSoFar + i);
                    chosen.remove(chosen.size() - 1);
                }
            }
        }

    }


    private static void diceRollWithSum1(int numberOfDice, List<List<Integer>> resultSum, List<Integer> chosen, int desiredSum) {

        if(numberOfDice == 0){
            if(desiredSum == 0){
                resultSum.add(new ArrayList<>(chosen));
            }
        }

        else if((desiredSum >= numberOfDice * 1) && (desiredSum <= numberOfDice * 6)){
            for(int i = 1; i <= 6; i++){

                    chosen.add(i);
                    diceRollWithSum1(numberOfDice - 1,resultSum,chosen,desiredSum - i);
                    chosen.remove(chosen.size() - 1);

            }
        }

    }

    private static void printAllCombinations(int numberOfDice, List<List<Integer>> result, List<Integer> temp) {

        if(numberOfDice == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int j = 1; j <=6; j++){
                temp.add(j);
                printAllCombinations(numberOfDice - 1, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
}
