import java.util.ArrayList;
import java.util.Scanner;

public class PrintAllPaths {
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
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vertices = scn.nextInt();
        int edges = scn.nextInt();
         scn.nextLine();

        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[vertices];
        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<edges; i++){
            String str = scn.nextLine();
            String[] parts = str.split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = scn.nextInt();
        int dest = scn.nextInt();

        boolean[] visited = new boolean[vertices];
        printAllPaths(graph, src, dest, visited, src + "");

    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf){
        if(src == dest){
            System.out.println(psf);
            return;
        }

        visited[src] = true;
        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
                printAllPaths(graph, edge.nbr, dest, visited, psf+edge.nbr);
            }
        }

        visited[src] = false;
    }
}

//? input
// 7
// 8
// 0 1 10
// 0 3 10
// 1 2 10
// 2 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
// 0
// 6