import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MultiSolverPaths {

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

    public static class Pair implements Comparable<Pair>{
        int wsf;
        String psf;

        Pair(int wsf, String psf){
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf;
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

        int src = scn.nextInt();
        int dest = scn.nextInt();
        int criteria = scn.nextInt();
        int k= 3;

        boolean[] visited = new boolean[vertices];
        multiSolverPaths(graph, src, dest, visited, criteria, src + "", 0, k);
        System.out.println("Shortest path = " + spath + " @ " + spathwt);
        System.out.println("Largest path = " + lpath + " @ " + lpathwt);
        System.out.println("Ceiling path = " + cpath + " @ " + cpathwt);
        System.out.println("Floor path = " + fpath + " @ " + fpathwt);
    }

    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;

    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;

    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;

    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;

    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void multiSolverPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, String psf, int wsf, int k){
        if(src == dest){

            if(wsf < spathwt){
                spath = psf;
                spathwt = wsf;
            }

            if(wsf > lpathwt){
                lpath = psf;
                lpathwt = wsf;
            }

            if(wsf > criteria && wsf < cpathwt){
                cpath = psf;
                cpathwt = wsf;
            }

            if(wsf < criteria && wsf > fpathwt){
                fpath = psf;
                fpathwt = wsf;
            }

            if(pq.size() < k){
                pq.add(new Pair(wsf, psf));
            }else{
                if(pq.peek().wsf < wsf){
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }

            return;
        }

        visited[src] = true;
        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
                multiSolverPaths(graph, edge.nbr, dest, visited, criteria, psf + edge.nbr, wsf + edge.wt, k);
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
// 42