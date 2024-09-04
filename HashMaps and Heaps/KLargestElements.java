import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = {2, 10 , 5, 17, 7, 18, 6, 4};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int kLargest = 3;

        for(int i=0; i<kLargest; i++){
            pq.add(arr[i]);
        }

        for(int i=kLargest; i<arr.length; i++){
            if(arr[i] > pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }

        while(pq.size() > 0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
