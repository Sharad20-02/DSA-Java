package Recursion;

public class print_sub_sequence {
    public static void main(String[] args) {
        String str = "abc";
        printSubSequence(str, "");
    }

    public static void printSubSequence(String question, String answer){

        if(question.length() == 0){
            System.out.println(answer);
            return;
        }

        char current_char = question.charAt(0);
        String roq = question.substring(1);
        printSubSequence(roq, answer + "");
        printSubSequence(roq, answer + current_char);
    }
}
