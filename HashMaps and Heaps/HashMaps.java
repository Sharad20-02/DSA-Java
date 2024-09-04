import java.util.HashMap;
import java.util.Set;

public class HashMaps{
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 140);
        hm.put("China", 130);
        hm.put("US", 56);
        hm.put("UK", 45);
        hm.put("NZ", 23);

        System.out.println(hm);

        hm.put("Nigeria", 55);
        hm.put("US", 66);

        System.out.println(hm);

        System.out.println(hm.get("India"));
        System.out.println(hm.get("Utopia"));

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Utopia"));

        Set<String> keys = hm.keySet();
        System.out.println("keys = " + keys);

        for(String key : hm.keySet()){
            System.out.println(key + " " + hm.get(key));
        }
    }
}