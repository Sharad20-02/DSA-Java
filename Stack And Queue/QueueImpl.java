public class QueueImpl {

    public static class NormalQueue{
        int[] data;
        int front;
        int size;

        public NormalQueue(int cap){
            this.data = new int[cap];
            this.front = 0;
            this.size = 0;
        }

        int size(){
            return size;
        }

        void display(){
            for(int i=0; i<size; i++){
                int idx = (front+i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }

        void add(int val){
            if(size == data.length){
                // System.out.println("Queue Overflow");
                int[] ndata = new int[data.length * 2];
                for(int i=0; i<size; i++){
                    int idx = (front+i) % data.length;
                    ndata[i] = data[idx];
                }
                data = ndata;
                front = 0;
                
                int addIndex = (front+size) % data.length;
                data[addIndex] = val;
                size++;
                
            }else{
                int addIndex = (front+size) % data.length;
                data[addIndex] = val;
                size++;
            }
        }

        int remove(){
            if(size == 0){
                System.out.println("Queue Underflow");
                return -1;
            }else{
                int removedElement = data[front];
                front = (front+1) % data.length;
                size--;
                return removedElement;
            }
        }

        int peek(){
            if(size == 0){
                System.out.println("Queue Underflow");
                return -1;
            }else{
                return data[front];
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
