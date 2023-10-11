package Recursion;

import java.util.ArrayList;

public class get_keypad_combination {
    public static void main(String[] args) {
        String str = "523";
        ArrayList<String> words = keypadCombination(str);
        System.out.println(words);
        System.out.println("Length: "+ words.size());
    }
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static ArrayList<String> keypadCombination(String str){
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        String first = codes[str.charAt(0) - '0'];
        ArrayList<String> rres = keypadCombination(str.substring(1));
        ArrayList<String> mres = new ArrayList<>();

        for(int i=0; i<first.length(); i++){
            for(int j=0; j<rres.size(); j++){
                mres.add(first.charAt(i) + rres.get(j));
            }
        }
        return mres;   
    }
}
