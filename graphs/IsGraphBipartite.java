import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class IsGraphBipartite {
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
        int level;

        Pair(int v, String psf, int level){
            this.v = v;
            this.psf = psf;
            this.level = level;
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
        
        int[] visited = new int[vertices];
        Arrays.fill(visited, -1);

        for(int i=0; i<vertices; i++){
            if(visited[i] == -1){
                boolean res = isBipartite(graph, visited, i);
                if(res == false){
                    System.out.println("Not Bipartite");
                    return;
                }
            }
        }
        System.out.println("Bipartite");
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph, int[] visited, int src){
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + "", 0));

        while(!queue.isEmpty()){

            Pair top = queue.pop();

            if(visited[top.v] != -1){
                if(top.level != visited[top.v]){
                    return false;
                }
            }else{
                visited[top.v] = top.level;
            }

            for(Edge e : graph[top.v]){
                if(visited[e.nbr] == -1){
                    queue.add(new Pair(e.nbr, top.psf+e.nbr, top.level+1));
                }
            }
        }
        return true;
    }
}

// 7
// 8
// 0 1 10
// 1 2 10
// 2 3 10
// 3 0 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10

// 7
// 6
// 0 1 10
// 1 2 10
// 3 0 10
// 3 4 10
// 5 6 10
// 4 6 10

// 7
// 7
// 0 1 10
// 1 2 10
// 2 3 10
// 3 0 10
// 3 4 10
// 4 5 10
// 4 6 10