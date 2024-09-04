package DynamicProgramming;

import java.util.Scanner;

public class PaintHouses {
    public static void main(String[] args) {
        int n;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();

        int[][] arr = new int[n][3];

        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int red = arr[0][0];
        int blue =  arr[0][1];
        int green = arr[0][2];

        for(int i=1; i<n; i++){
            int newRed = arr[i][0] + Math.min(blue, green);
            int newBlue = arr[i][1] + Math.min(red, green);
            int newGreen = arr[i][2] + Math.min(blue, red);

            red = newRed;
            blue = newBlue;
            green = newGreen;
        }
        System.out.println(Math.min(red, Math.min(blue, green)));

    }
}
