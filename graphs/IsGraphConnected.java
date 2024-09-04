import java.util.ArrayList;
import java.util.Scanner;

public class IsGraphConnected {
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

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[vertices];

        for(int v=0; v<vertices; v++){
            if(visited[v] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                GetAllConnectedComponents(graph, v, visited, comp);
                comps.add(comp);
            }
        }

        if(comps.size() == 1){
            System.out.println("Connected graph");
        }else{
            System.out.println("Not a Connected graph");
        }
    }

    public static void GetAllConnectedComponents(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp){
        visited[src] = true;
        comp.add(src);

        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
                GetAllConnectedComponents(graph, edge.nbr, visited, comp);
            }
        }
    }
}
