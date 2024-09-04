package DynamicProgramming;

import java.util.Scanner;

public class ArrangeBuildings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        if(n == 0){
            System.out.println(0);
        }

        int prevBuilding = 1;
        int prevSpace = 1;

        for(int i=2; i<=n; i++){
            int currBuilding = prevSpace;
            int currSpace = prevBuilding + prevSpace;

            prevBuilding = currBuilding;
            prevSpace = currSpace;
        }
        int total = prevBuilding + prevSpace;
        System.out.println(total * total);
    }
}
