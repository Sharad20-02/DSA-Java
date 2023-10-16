package Recursion;

public class print_keypad_combination {
    public static void main(String[] args) {
        String str = "123";
        printKeypadCombination(str, "");
    }
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void printKeypadCombination(String ques, String ans){
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        int chv = ch - '0';
        for(int i=0; i<codes[chv].length(); i++){
            printKeypadCombination(roq, ans+codes[chv].charAt(i));
        }
    }
}
