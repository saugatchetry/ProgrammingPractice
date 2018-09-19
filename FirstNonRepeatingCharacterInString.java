import java.util.HashMap;
public class FirstNonRepeatingCharacterInString {
    public static void main(String[] args) {
        String input = "abba";
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character ch : input.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }

        for(Character ch : input.toCharArray()){
            int freq = map.get(ch);
            if(freq == 1){
                System.out.println("First Non Repeating Character = "+ch);
                break;
            }
        }

    }

    class MyObject{
        int index;
        int frequency;
        public MyObject(int index, int frequency){
            this.index = index;
            this.frequency = frequency;
        }
    }
}
