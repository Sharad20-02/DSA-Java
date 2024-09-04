import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Adapters {

    public static class QueueToStackAdapterPopEfficient{
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        QueueToStackAdapterPopEfficient(){
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size(){
            return mainQ.size();
        }

        void push(int val){
            if(size() == 0){
                mainQ.add(val);
            }else{
                while(!mainQ.isEmpty()){
                    helperQ.add(mainQ.remove());
                }
                mainQ.add(val);
                while(!helperQ.isEmpty()){
                    mainQ.add(helperQ.remove());
                }
            }
        }

        int pop(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                return mainQ.remove();
            }
        }

        int top(){
            if(size() == 0){
                System.out.println("Stack Underflow");
                return -1;
            }else{
                return mainQ.peek();
            }
        }
    }

    public static class QueueToStackAdapterPushEfficient{
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        QueueToStackAdapterPushEfficient(){
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size(){
            return mainQ.size();
        }

        void push(int val){
            mainQ.add(val);
        }

        int pop(){
            if(size() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                while(mainQ.size() > 1){
                    helperQ.add(mainQ.remove());
                }
                int toBeRemoved = mainQ.remove();

                while(!helperQ.isEmpty()){
                    mainQ.add(helperQ.remove());
                }

                return toBeRemoved;
            }
        }

        int top(){
            if(size() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                while(mainQ.size() > 1){
                    helperQ.add(mainQ.remove());
                }
                int top = mainQ.peek();
                helperQ.add(mainQ.remove());

                while(!helperQ.isEmpty()){
                    mainQ.add(helperQ.remove());
                }
                return top;
            }
        }
    }

    public static class StackToQueueAdapterRemoveEfficient{
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapterRemoveEfficient(){
            this.mainS = new Stack<>();
            this.helperS = new Stack<>();
        }

        int size(){
            return mainS.size();
        }

        void add(int val){
            if(size() == 0){
                mainS.push(val);
            }else{
                while(!mainS.isEmpty()){
                    helperS.push(mainS.pop());
                }
                mainS.push(val);
                while(!helperS.isEmpty()){
                    mainS.push(helperS.pop());
                }
            }
        }

        int remove(){
            if(size() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                return mainS.pop();
            }
        }

        int peek(){
            if(size() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                return mainS.peek();
            }
        }

    }

    public static class StackToQueueAdapterAddEfficient{
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapterAddEfficient(){
            this.mainS = new Stack<>();
            this.helperS = new Stack<>();
        }

        int size(){
            return mainS.size();
        }

        void add(int val){
            mainS.push(val);
        }

        int remove(){
            if(size() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                while(!mainS.isEmpty()){
                    helperS.push(mainS.pop());
                }

                int top = helperS.pop();

                while(!helperS.isEmpty()){
                    mainS.push(helperS.pop());
                }

                return top;
            }
        }

        int peek(){
           if(size() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                while(!mainS.isEmpty()){
                    helperS.push(mainS.pop());
                }

                int top = helperS.peek();
                
                while(!helperS.isEmpty()){
                    mainS.push(helperS.pop());
                }

                return top;
            }
        }

    }

    public static class TwoStackInOneArray{
        int[] data;
        int tos1;
        int tos2;

        public TwoStackInOneArray(int cap){
            this.data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }

        int size1(){
            return tos1+1;
        }

        int size2(){
            return data.length - tos2;
        }

        void push1(int val){
            if(size1() + size2() >= data.length){
                System.out.println("Overflow");
            }else{
                tos1++;
                data[tos1] = val;
            }
        }

        void push2(int val){
            if(size1() + size2() >= data.length){
                System.out.println("Overflow");
            }else{
                tos2--;
                data[tos2] = val;
            }
        }

        int top1(){
            if(size1() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                return data[tos1];
            }
        }

        int top2(){
            if(size2() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                return data[tos2];
            }
        }

        int pop1(){
            if(size1() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                int removed = data[tos1];
                tos1--;
                return removed;
            }
        }

        int pop2(){
            if(size2() == 0){
                System.out.println("Underflow");
                return -1;
            }else{
                int removed = data[tos2];
                tos2++;
                return removed;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
