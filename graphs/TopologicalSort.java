import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {
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
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<edges; i++){
            String[] parts = scn.nextLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            graph[v1].add(new Edge(v1, v2, wt)); //? directed graph
            // graph[v2].add(new Edge(v2, v1, wt));
        }

        boolean[] visited = new boolean[vertices];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<vertices; i++){
            if(visited[i] == false){
                topologicalSort(graph, i, visited, st);
            }
        }

        System.out.println(st);
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st){
        
        visited[src] = true;
        for(Edge e: graph[src]){
            if(visited[e.nbr] == false){
                topologicalSort(graph, e.nbr, visited, st);
            }
        }

        st.push(src);

    }
}

// 7
// 8
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 40
// 4 3 2
// 4 5 3
// 5 6 3
// 4 6 8