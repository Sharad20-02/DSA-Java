import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsAlgorithm {
    public static class Edge{
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int v;
        int av;
        int cost;

        Pair(int v, int av, int cost){
            this.v = v;
            this.av = av;
            this.cost = cost;
        }

        public int compareTo(Pair o){
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vertices = scn.nextInt();
        int edges = scn.nextInt();
        scn.nextLine();
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<edges; i++){
            String[] parts = scn.nextLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));

        boolean[] visited = new boolean[vertices];

        while(!pq.isEmpty()){
            Pair top = pq.remove();

            if(visited[top.v] == true){
                continue;
            }

            visited[top.v] = true;
            if(top.av != -1){
                System.out.println(top.v + " <--> " + top.av + " @ " + top.cost);
            }
            for(Edge e : graph[top.v]){
                if(visited[e.nbr] == false){
                    pq.add(new Pair(e.nbr, e.src, e.wt));
                }
            }
        }
    }
}

// 7
// 8
// 0 1 10
// 1 2 10
// 2 3 10
// 3 0 40
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8