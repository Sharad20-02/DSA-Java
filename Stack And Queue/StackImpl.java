public class StackImpl {

    public static class CustomStack{
        int[] data;
        int tos;

        public CustomStack(int cap){
            this.data = new int[cap];
            this.tos = -1;
        }

        int size(){
            return tos+1;
        }

        void display(){
            for(int i=tos; i>=0; i--){
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int val){
            if(tos == data.length-1){
                int[] newData = new int[data.length*2];
                for(int i=0; i<data.length; i++){
                    newData[i] = data[i];
                }
                tos++;
                newData[tos] = val;
                data = newData;
            }else{
                tos++;
                data[tos] = val;
            }
        }

        int pop(){
            if(tos == -1){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                int num = data[tos];
                tos--;
                return num;
            }
        }

        int top(){
            if(tos == -1){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                return data[tos];
            }
        }
    }
    
    public static void main(String[] args) {
        
    }
}
