package Recursion;

public class print_combinations {
    public static void main(String[] args) {
        String str = "abcd";
        printCombinations(str, "");
    }
    public static void printCombinations(String ques, String ans){
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        
        for(int i=0 ;i<ques.length(); i++){
            char ch = ques.charAt(i);
            String ls = ques.substring(0, i);
            String rs = ques.substring(i+1);
            String roq = ls + rs;
            printCombinations(roq, ans + ch);
        }
    }
}
