package DynamicProgramming;

import java.util.Scanner;

public class MaximumSumNonAdjacentElements {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int include = arr[0];
        int exclude = 0;

        for(int i=1; i<n; i++){
            int nextInclude = exclude + arr[i];
            int nextExclude = Math.max(include, exclude);

            include = nextInclude;
            exclude = nextExclude;
        }
        System.out.println(Math.max(include, exclude));
    }
}
