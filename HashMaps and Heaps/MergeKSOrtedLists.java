import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSOrtedLists {

    public static class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;

        Pair(int li, int di, int val){
            this.li = li;
            this.di = di;
            this.val = val;
        }

        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }

    public static void main(String[] args) {
        int k = 4;

        int[] arr1 = {10, 20, 30, 40, 50};
        int[] arr2 = {5, 7, 9, 11, 19, 55, 57};
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {32, 39};

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for(int i=0; i<arr1.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr1[i]);
            if(i == arr1.length-1){
                lists.add(list);
            }
        }

        for(int i=0; i<arr2.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr2[i]);
            if(i == arr2.length-1){
                lists.add(list);
            }
        }

        for(int i=0; i<arr3.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr3[i]);
            if(i == arr3.length-1){
                lists.add(list);
            }
        }

        for(int i=0; i<arr4.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr4[i]);
            if(i == arr4.length-1){
                lists.add(list);
            }
        }


        
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<lists.size(); i++){
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }

        while(pq.size() > 0){
            Pair p = pq.remove();
            rv.add(p.val);

            p.di++;

            if(p.di < lists.get(p.li).size()){
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }

        return rv;
    }
}
