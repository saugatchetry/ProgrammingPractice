import java.util.*;

public class Challenge {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int operations = in.nextInt();

        long maxValue = Integer.MIN_VALUE;
        List<MyObject> list = new ArrayList();

        for(int i = 0; i < operations; i++){
            int start = in.nextInt();
            int end = in.nextInt();
            int val = in.nextInt();

            MyObject startObject = new MyObject(start, val, 0);
            MyObject endObject = new MyObject(end,val, 1);
            list.add(startObject);
            list.add(endObject);
        }

        Collections.sort(list, new Comparator<MyObject>(){
            public int compare(MyObject a, MyObject b){
                if(a.index != b.index)
                    return a.index - b.index;
                else
                    return a.start - b.start;
            }
        });

        //System.out.println(list);

        long cur = 0;
        for(MyObject m : list){
            if(m.start == 0)
                cur+= m.value;
            else
                cur-=m.value;
            maxValue = Math.max(cur, maxValue);
        }
        System.out.println( maxValue);
    }
}

class MyObject {
    int value =0;
    int start;
    int index;

    public MyObject(int index, int val, int s){
        this.index = index;
        this.value = val;
        this.start = s;
    }

    public String toString(){
        return "Index = "+index+" Value = "+value+" Start = "+start;
    }
}
