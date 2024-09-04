package DynamicProgramming;

import java.util.Scanner;

public class CountSubsequences {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        int a = 0;
        int ab = 0;
        int abc = 0;

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == 'a'){
                a = (2*a) + 1;
            }else if (c == 'b'){
                ab = (2*ab) + a;
            }else{
                abc = (2*abc) + ab;
            }
        }
        System.out.println(abc);
    }
}
