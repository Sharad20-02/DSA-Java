import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{

    public static class Pair implements Comparable<Pair>{
        int exp;
        int bns;

        public Pair(int exp, int bns){
            this.exp = exp;
            this.bns = bns;
        }

        public int compareTo(Pair o){
            return this.exp - o.exp;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int myExp = scn.nextInt();

        int[] exp = new int[n];
        int[] bns = new int[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            exp[i] = scn.nextInt();    
        }
        for(int i=0; i<n; i++){
            bns[i] = scn.nextInt();    
        }

        for(int i=0; i<n; i++){
            pq.add(new Pair(exp[i], bns[i]));
        }

        int count = 0;
        while(!pq.isEmpty() && pq.peek().exp <= myExp){
            Pair p = pq.remove();
            myExp += p.bns;
            count++;
        }

        System.out.println(count);
    }
}