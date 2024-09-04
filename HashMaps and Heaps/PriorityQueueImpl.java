import java.util.ArrayList;

public class PriorityQueueImpl {

    public static class PriorityQueue{
        ArrayList<Integer> data;

        public PriorityQueue(){
            data = new ArrayList<>();
        }

        public void add(int val){
            this.data.add(val);
            upheapify(data.size() - 1);
        }

        private void upheapify(int i){
            if(i == 0){
                return;
            }

            int pi = (i - 1) / 2;
            if(data.get(i) < data.get(pi)){
                swap(i, pi);
                upheapify(pi);
            }
        }

        private void swap(int i, int j){
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public int remove(){
            if(this.data.size() == 0){
                System.out.println("Underflow");
                return -1;
            }

            swap(0, this.data.size() - 1);
            int val = data.remove(data.size() - 1);

            downheapify(0);

            return val;
        }

        private void downheapify(int pi){
            int mini = pi;
            
            int li = 2 * pi + 1;
            if(li < data.size() && data.get(li) < mini){
                mini = li;
            }

            int ri = 2* pi + 2;
            if(ri < data.size() && data.get(ri) < mini){
                mini = ri;
            }

            if(mini != pi){
                swap(pi, mini);
                downheapify(mini);
            }

        }

        public int peek(){
            if(this.data.size() == 0){
                System.out.println("Underflow");
                return -1;
            }
            return this.data.get(0);
        }

        public int size(){
            return this.data.size();
        }
    }
    public static void main(String[] args) {
        
    }
}
