import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class BreadthFirstTraversal {

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

    public static class Pair{
        int v;
        String psf;

        Pair(int v, String psf){
            this.v = v;
            this.psf = psf;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vertices = 7;
        int edges = 8;
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

        int src = 0;

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src+ ""));
        boolean[] visited = new boolean[vertices];

        while(!queue.isEmpty()){
            Pair top = queue.pop();
            if(visited[top.v] == false){
                visited[top.v] = true;
                System.out.println(top.v + " @ " + top.psf);
                for(Edge e : graph[top.v]){
                    if(visited[e.nbr] == false){
                        queue.add(new Pair(e.nbr, top.psf+e.nbr));
                    }
                }
            }
        }
    }
}

// 0 1 10
// 1 2 10
// 2 3 10
// 3 0 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
