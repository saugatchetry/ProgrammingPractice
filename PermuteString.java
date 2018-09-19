import java.util.ArrayList;
import java.util.List;

public class PermuteString {
    public static void main(String[] args) {
        String input = "ABC";
        int startIndex = 0;
        int endIndex = input.length() - 1;
        permuteString(input,startIndex, endIndex);
    }

    private static void permuteString(String input, int startIndex, int endIndex ) {
        if(startIndex == endIndex){
            System.out.println(input);
        }
        else{
            for(int i = startIndex; i <= endIndex; i++){
                input = swapCharacters(input,startIndex, i);
                permuteString(input,startIndex+1,endIndex);
                input = swapCharacters(input,startIndex, i);
            }
        }
    }

    private static String swapCharacters(String input, int startIndex, int endIndex) {
        char[] charArray = input.toCharArray();
        char temp = charArray[startIndex];
        charArray[startIndex] = charArray[endIndex];
        charArray[endIndex] = temp;
        return String.valueOf(charArray);
    }
}
