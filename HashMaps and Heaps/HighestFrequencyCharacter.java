import java.util.HashMap;

public class HighestFrequencyCharacter {
    public static void main(String[] args) {
        String str = "abracadabra";
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch) == true){
                hm.put(ch, hm.get(ch)+1);
            }else{
                hm.put(ch, 1);
            }
        }

        int maxi = Integer.MIN_VALUE;
        char maxChar = ' ';
        for(char key : hm.keySet()){
            if(hm.get(key) > maxi){
                maxChar = key;
                maxi = hm.get(key);
            }
        }
        System.out.println("Maximum frequency character = " + maxChar + " | count = " + maxi);
    }
}
