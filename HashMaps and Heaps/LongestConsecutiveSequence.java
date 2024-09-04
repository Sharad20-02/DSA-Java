import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2};

        HashMap<Integer, Boolean> hm = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            hm.put(arr[i], true);
        }

        for(int val : arr){
            if(hm.containsKey(val - 1) == true){
                hm.put(val, false);
            }
        }

        int msp = 0;
        int ml = 0;

        for(int val : arr){
            if(hm.get(val) == true){
                int tl = 1;
                int tsp = val;

                while(hm.containsKey(tsp + tl) == true){
                    tl++;
                }

                if(tl > ml){
                    ml = tl;
                    msp = tsp;
                }
            }
        }

        for(int i=0; i<ml; i++){
            System.out.print(msp + i + " ");
        }
    }
}
