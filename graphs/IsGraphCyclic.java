import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class IsGraphCyclic {
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

        boolean[] visited = new boolean[vertices];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<vertices; i++){
            if(visited[i] == false){
                queue.add(i);
                boolean res = bfs(graph, visited, queue, i);
                if(res){
                    System.out.println("Cyclic");
                    return;
                }
            }
        }
        System.out.println("Not Cyclic");
    }
    
    public static boolean bfs(ArrayList<Edge>[] graph, boolean[] visited, ArrayDeque<Integer> queue, int src){
        
        while(!queue.isEmpty()){
            int top = queue.pop();
            if(visited[top] == true){
                return true;
            }
            visited[top] = true;
            for(Edge e : graph[top]){
                if(visited[e.nbr] == false){
                    queue.add(e.nbr);
                }
            }
        }
        return false;
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