import java.util.Stack;

public class MinimumStack {

    public static class MinStack{
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack(){
            this.allData = new Stack<>();
            this.minData = new Stack<>();
        }

        int size(){
            return allData.size();
        }

        int min(){
            if(allData.isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            return minData.peek();
        }

        void push(int val){
            allData.push(val);

            if(minData.isEmpty() == true || minData.peek() >= val){
                minData.push(val);
            }
        }

        int pop(){
            if(allData.isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
    
            int top = allData.pop();
            if(!minData.isEmpty() && top == minData.peek()){
                minData.pop();
            }
            return top;
        }

        int top(){
            if(allData.isEmpty()){
                System.out.println("Stack Underflow");
                return -1;
            }
            return allData.peek();
        }
    }

    public static class MinStackCS{
        Stack<Integer> allData;
        int min;

        public MinStackCS(){
            this.allData = new Stack<>();
        }

        int size(){
            return allData.size();
        }

        void push(int val){
            if(allData.size() == 0){
                allData.push(val);
                min = val;
            }else{
                if(val < min){
                    int valToAdd = val + (val - min);
                    allData.push(valToAdd);
                    min = val;
                }else{
                    allData.push(val);
                }
            }
        }

        int pop(){
            if(allData.size() == 0){
                System.out.println("QueueUnderflow");
                return -1;
            }else{
                if(allData.peek() < min){
                    int topVal = allData.pop();
                    int orgTop = min;
                    min = orgTop + orgTop - topVal;
                    
                    return orgTop;
                }else{
                    return allData.pop();
                }
            }
        }

        int top(){
            if(allData.size() == 0){
                System.out.println("QueueUnderflow");
                return -1;
            }else{
                return allData.peek();
            }
        }

        int min(){
            if(allData.size() == 0){
                System.out.println("QueueUnderflow");
                return -1;
            }else{
                return min;
            }
        }

}

    public static void main(String[] args) {
        
    }
}
