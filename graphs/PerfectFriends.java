import java.util.ArrayList;
import java.util.Scanner;

public class PerfectFriends {

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
        int n = 7;
        int edges = 5;

        ArrayList<Edge>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges; i++){
            String line = scn.nextLine();
            String[] parts = line.split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = 1;
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        for(int v=0; v<n; v++){
            if(visited[v] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                getConnectedComponents(graph, v, comp, visited);
                comps.add(comp);
            }
        }
        System.out.println(comps);

        int count = 0;
        for(int i=0; i<comps.size(); i++){
            for(int j=i+1; j<comps.size(); j++){
                count += comps.get(i).size() * comps.get(j).size();
            }
        }
        System.out.println(count);
    }

    public static void getConnectedComponents(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src] = true;
        comp.add(src);

        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
                getConnectedComponents(graph, edge.nbr, comp, visited);
            }
        }
    }
}

// 7
// 5
// 0 1
// 2 3
// 4 5
// 5 6
// 4 6