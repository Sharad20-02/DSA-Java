import java.util.HashMap;

public class GetCommonElementsTwo {
    public static void main(String[] args) {
        int[] a1 = {1,1,6,1,7,2,5,7,9,9,9};
        int[] a2 = {1,1,1,1,6,9,7,7,7,7,4};

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<a1.length; i++){
            if(hm.containsKey(a1[i]) == true){
                hm.put(a1[i], hm.get(a1[i]) + 1);
            }else{
                hm.put(a1[i], 1);
            }
        }

        for(int i=0; i<a2.length; i++){
            if(hm.containsKey(a2[i]) == true){
                if(hm.get(a2[i]) > 0){
                    System.out.print(a2[i] + " ");
                    hm.put(a2[i], hm.get(a2[i]) - 1);
                }
            }
        }
    }
}
