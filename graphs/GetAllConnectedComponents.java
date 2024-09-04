import java.util.ArrayList;
import java.util.Scanner;

public class GetAllConnectedComponents {

    public static class Edge{
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt){
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

        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<>();
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

        boolean[] visited = new boolean[vertices];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();        

        for(int v=0; v<vertices; v++){
            if(visited[v] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                drawTree(graph, v, comp, visited);
                comps.add(comp);
            }
        }
        
        System.out.println(comps);

    }

    public static void drawTree(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src] = true;
        comp.add(src);

        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
                drawTree(graph, edge.nbr, comp, visited);
            }
        }
    }
}

// 7
// 5
// 0 1 10
// 2 3 10
// 4 5 10
// 4 6 10
// 5 6 10