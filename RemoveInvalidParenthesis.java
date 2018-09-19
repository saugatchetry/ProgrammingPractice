import java.util.*;

public class RemoveInvalidParenthesis {
    public static void main(String[] args) {
        String s = "()())()";
        List<String> result = removeInvalidParentheses(s);
        System.out.println(result);
    }

//    private static List<String> removeInvalidParentheses(String s) {
//        Set<String> res = new HashSet<>();
//        int rmL = 0, rmR = 0;
//        for(int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == '(') rmL++;
//            if(s.charAt(i) == ')') {
//                if(rmL != 0) rmL--;
//                else rmR++;
//            }
//        }
//
//        System.out.println("RML = "+rmL+" RmR = "+rmR);
//        DFS(res, s, 0, rmL, rmR, 0, new StringBuilder());
//        return new ArrayList<String>(res);
//    }

//   private static void DFS(Set<String> res, String s, int i, int rmL, int rmR, int open, StringBuilder sb) {
//        if(i == s.length() && rmL == 0 && rmR == 0 && open == 0) {
//            res.add(sb.toString());
//            return;
//        }
//        if(i == s.length() || rmL < 0 || rmR < 0 || open < 0) return;
//
//        char c = s.charAt(i);
//        int len = sb.length();
//
//        if(c == '(') {
//            DFS(res, s, i + 1, rmL - 1, rmR, open, sb);
//            DFS(res, s, i + 1, rmL, rmR, open + 1, sb.append(c));
//
//        } else if(c == ')') {
//            DFS(res, s, i + 1, rmL, rmR - 1, open, sb);
//            DFS(res, s, i + 1, rmL, rmR, open - 1, sb.append(c));
//
//        } else {
//            DFS(res, s, i + 1, rmL, rmR, open, sb.append(c));
//        }
//
//        sb.setLength(len);
//    }


    private static List<String> removeInvalidParentheses(String s) {
        /*String r = remove(s, new char[]{'(', ')'});
        String tmp = remove(new StringBuilder(r).reverse().toString(), new char[]{')', '('});
        return new StringBuilder(tmp).reverse().toString();*/

        List<String> res = new ArrayList<>();
        dfs(res, s, new char[]{'(', ')'}, 0, 0);
        return res;
    }
    private static String remove(String s, char[] p) {
        int stack = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == p[0])		stack++;
            if (s.charAt(i) == p[1])		stack--;
            if (stack < 0) {
                s = s.substring(0, i) + s.substring(i + 1);
                i--;
                stack = 0;
            }
        }
        return s;
    }


    private static void dfs(List<String> res, String s, char[] p, int iStart, int jStart) {
        // find 1st invalid p[1]
        int stack = 0, i;
        for (i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == p[0])		stack++;
            if (s.charAt(i) == p[1])		stack--;
            // remove each (not consecutive) p[1] from jStart to i to make valid
            if (stack < 0) {
                for (int j = jStart; j <= i; j++) // <=
                    if (s.charAt(j) == p[1] && (j == jStart || s.charAt(j - 1) != p[1])) {
                        String r = s.substring(0, j) + s.substring(j + 1);
                        dfs(res, r, p, i, j);
                    }
                return; // important!!
            }
        }
        // stack >= 0 : try reverse s and re-do DFS; if already reversed, then add to res
        String reverse = new StringBuilder(s).reverse().toString();
        if (p[0] == '(')
            dfs(res, reverse, new char[]{')', '('}, 0, 0); // important: 0, 0
        else
            res.add(reverse);
    }

    public static List<String> removeInvalidParenthesesBFS(String s) {
        List<String> res = new ArrayList<>();
        if (s == null)	return res;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>(); // avoid duplicate results
        q.offer(s);
        visited.add(s);
        boolean foundValid = false;
        while (!q.isEmpty()) {
            String t = q.poll();
            if (isValid(t)) {
                res.add(t);
                foundValid = true;
            }
            // found valid, no need to remove anymore, just iterative the rest of q and add to res when necessary
            if (foundValid)		continue;
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) != '(' && t.charAt(i) != ')')	continue;
                String r = t.substring(0, i) + t.substring(i + 1);
                if (visited.contains(r))	continue;
                visited.add(r);
                q.offer(r);
            }
        }
        return res;
    }

    private static boolean isValid(String s) {
        int count = 0; // stack variable
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')		count++;
            if (s.charAt(i) == ')') {
                count--;
                if(count <   0)
                    return false;
            }

        }
        return count == 0;
    }
}
