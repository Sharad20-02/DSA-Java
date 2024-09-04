import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class HamiltonianPathsCycles {
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
        int vertices = 7;
        int edges = 9;

        ArrayList<Edge>[] graph = new ArrayList[vertices];
        HashSet<Integer> visited = new HashSet<>();

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

        int src = 0;
        printHamiltonian(graph, src, src + "", visited, src);
    }

    public static void printHamiltonian(ArrayList<Edge>[] graph, int src, String psf, HashSet<Integer> visited, int originalSrc){

        if(visited.size() == graph.length - 1){
            System.out.print(psf);

            boolean closingEdgeFound = false;
            for(Edge e : graph[src]){
                if(e.nbr == originalSrc){
                    closingEdgeFound = true;
                    break;
                }
            }
            if(closingEdgeFound){
                System.out.print("*\n");
            }else{
                System.out.print(".\n");
            }
            return;
        }

        visited.add(src);

        for(Edge edge : graph[src]){
            if(!visited.contains(edge.nbr)){
                printHamiltonian(graph, edge.nbr, psf+edge.nbr, visited, originalSrc);
            }
        }

        visited.remove(src);
    }
}


// 0 1 10
// 0 3 10
// 1 2 10
// 2 3 10
// 3 4 10
// 4 5 10
// 5 6 10
// 4 6 10
// 2 5 10