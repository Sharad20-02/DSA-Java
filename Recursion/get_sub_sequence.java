package Recursion;

import java.util.ArrayList;

public class get_sub_sequence{
    public static void main(String[] args) {
        String str = "abcd";
        ArrayList<String> res = gss(str);
        System.out.println(res);
    }

    public static ArrayList<String> gss(String str){

        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rres = gss(ros);
        ArrayList<String> mres = new ArrayList<>();

        for(int i=0; i<rres.size(); i++){
            mres.add("" + rres.get(i));
        }
        for(int i=0; i<rres.size(); i++){
            mres.add(ch + rres.get(i));
        }
        return mres;
    }
}