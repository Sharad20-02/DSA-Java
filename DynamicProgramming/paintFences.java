package DynamicProgramming;

import java.util.Scanner;

public class paintFences {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int fences = scn.nextInt();
        int colors = scn.nextInt();

        int lastTwoSame = colors;
        int lastTwoDifferent = colors * (colors-1);

        for(int i=3; i<=fences; i++){
            int newLastTwoSame = lastTwoDifferent;
            int newLastTwoDifferent = (lastTwoDifferent + lastTwoSame) * (colors - 1);

            lastTwoDifferent = newLastTwoDifferent;
            lastTwoSame = newLastTwoSame;
        }
        System.out.println(lastTwoDifferent + lastTwoSame);
    }
}
