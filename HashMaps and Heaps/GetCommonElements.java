import java.util.HashMap;

public class GetCommonElements {
    public static void main(String[] args) {
        int[] a1 = {1,1,6,1,2,2,5,7,8,8,9};
        int[] a2 = {1,1,1,1,6,9,7,7,7,7,4};

        HashMap<Integer, Boolean> hm = new HashMap<>();

        for(int i=0; i<a1.length; i++){
            hm.put(a1[i], true);
        }

        for(int i=0; i<a2.length; i++){
            if(hm.containsKey(a2[i]) == true){
                if(hm.get(a2[i]) == true){
                    System.out.println(a2[i]);
                    hm.put(a2[i], false);
                }
            }
        }
    }
}
