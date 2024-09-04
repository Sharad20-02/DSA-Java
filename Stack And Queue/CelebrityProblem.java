import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int n = 5;
        int[][] arr = {{0, 1, 1, 1, 1},
                       {1, 0, 0, 1, 0},
                       {1, 0, 0, 1, 0},
                       {0, 0, 0, 0, 0},
                       {0, 1, 0, 1, 0}};
        //! celebrity conditions:
        //! a) the person is known by everybody
        //! b) but the person himself does not know anybody
        //? there cannot be more than 1 celebrity

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            st.push(i);
        }

        while(st.size()>1){
            int p1 = st.pop();
            int p2 = st.pop();
            if(arr[p1][p2] == 1){
                //? ==> p1 knows p2
                //? ==> p1 cannot be celebrity
                st.push(p2);
            }else{
                //? ==> p1 does not know p2
                //? ==> p2 cannot be celebrity
                st.push(p1);
            }
        }

        int possibleCelebrity = st.peek();
        if(isCelebrity(arr, possibleCelebrity)){
            System.out.println(possibleCelebrity);
        }else{
            System.out.println("null");
        }

    }

    public static boolean isCelebrity(int[][] arr, int possibleCelebrity){
        for(int i=0; i<arr.length; i++){
            if(i != possibleCelebrity){
                if(arr[i][possibleCelebrity] == 0 || arr[possibleCelebrity][i] == 1){
                    return false;
                }
            }
        }
        return true;
    }
}
