public class ToLowerCase {
    public static void main(String[] args) {
        String input = "Hello";
        String result = toLowerCase(input);
        System.out.println(result);
    }

    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(Character ch : str.toCharArray()){
            if(ch >= 65 && ch <= 90){
                char newCh = (char)(ch - 'A' + 'a');
                sb.append(newCh);
            }
            else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
