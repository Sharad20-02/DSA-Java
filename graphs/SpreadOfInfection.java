import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class SpreadOfInfection {
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
        int time;

        Pair(int v, String psf, int time){
            this.v = v;
            this.psf = psf;
            this.time = time;
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

        int src = 6;
        int t = 3;
        int count = 0;

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src+"", 1));
        int[] visited = new int[vertices];

        while(!queue.isEmpty()){
            Pair top = queue.pop();

            if(top.time > t){
                break;
            }
            
            if(visited[top.v] == 0){
                visited[top.v] = top.time;
                count++;
                for(Edge e : graph[top.v]){
                    if(visited[e.nbr] == 0){
                        queue.add(new Pair(e.nbr, top.psf+e.nbr, top.time+1));
                    }
                }
            }
        }

        System.out.println(count);
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