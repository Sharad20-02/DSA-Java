import java.util.ArrayList;
import java.util.Scanner;

public class HasPath {

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
        boolean ans = doesPathExist(graph, src, dest, visited);


    }

    public static boolean doesPathExist(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src == dest){
            return true;
        }

        visited[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            int neighbour = graph[src].get(i).nbr;
            if(visited[neighbour] == false){
                boolean doesNbrHasPath = doesPathExist(graph, neighbour, dest, visited);
                if(doesNbrHasPath == true){
                    return true;
                }
            }
        }

        return false;
    }
}
