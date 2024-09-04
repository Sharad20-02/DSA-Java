import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals {

    public static class Pair implements Comparable<Pair>{
        int st;
        int et;

        public Pair(int st, int et){
            this.st = st;
            this.et =et;
        }

        public int compareTo(Pair o){
            if(this.st != o.st){
                return this.st - o.st;
            }else{
                return this.et - o.et;
            }
        }

        public String toString(Pair p){
            return this.st + " - " + this.et + " ";
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int [][] arr = {{22, 28},
                        {1, 8},
                        {25, 27},
                        {14, 19},
                        {27, 30},
                        {5, 12}};

        Pair[] pairs = new Pair[n];
        for(int i=0; i<n; i++){
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);

        for(int i=1; i<n; i++){
            Pair top = st.peek();
            if(pairs[i].st > top.et){
                st.push(pairs[i]);
            }else{
                if(top.et < pairs[i].et){
                    top.et = pairs[i].et;
                }
            }
        }

        for(int i=st.size()-1; i>=0; i--){
            Pair p = st.pop();
            System.out.println(p.st + " - " + p.et);
        }
        
    }
}
