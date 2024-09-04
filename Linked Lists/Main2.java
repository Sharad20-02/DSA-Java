import java.util.LinkedList;

public class Main2 {

    public static class LLToStackAdapter{
        LinkedList<Integer> list;

        LLToStackAdapter(){
            list = new LinkedList<>();
        }

        int size(){
            return list.size();
        }

        void push(int val){
            list.addFirst(val);
        }

        int pop(){
            if(size() == 0){
                System.out.println("Empty Stack");
                return -1;
            }
            return list.removeFirst();
        }

        int top(){
            if(size() == 0){
                System.out.println("Empty Stack");
                return -1;
            }
            return list.getFirst();
        }
    }

    public static class LLToQueueAdapter{
        LinkedList<Integer> list;

        int size(){
            return list.size();
        }

        void add(int val){
            list.addLast(val);
        }

        int remove(){
            if(size() == 0){
                System.out.println("Empty Stack");
                return -1;
            }else{
                return list.removeFirst();
            }
        }

        int peek(){
            if(size() == 0){
                System.out.println("Empty Stack");
                return -1;
            }else{
                return list.getFirst();
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
