package Recursion;

public class tower_of_hanoi {
    public static void main(String[] args) {
        int n = 3;
        String t1 = "A";  // Source
        String t2 = "B";  // Destination 
        String t3 = "C";  // Helper
        towerOfHanoi(n, t1, t2, t3);  
    }

    public static void towerOfHanoi(int n, String t1, String t2, String t3){
        if(n == 0){
            return;
        }
        towerOfHanoi(n-1, t1, t3, t2);
        System.out.println("Disk: " + n + " [ " + t1 + " ---> " + t2 + " ] ");
        towerOfHanoi(n-1, t3, t2, t1);
    }
}
