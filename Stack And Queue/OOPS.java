public class OOPS {
    public static void main(String[] args) {
        
        int n = 10;
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(n + " " + arr[0]);
        update(n, arr);
        System.out.println(n + " " + arr[0]);
    }

    public static void update(Integer num, int[] arr){
        num = 40;
        arr[0] = 999;
    }
}
