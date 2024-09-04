import java.util.ArrayList;
import java.util.Stack;

public class PrintKNodesFar {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right){
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public static class Pair{
        Node node;
        int state;

        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null}; //? pre-order

        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        constructBinaryTree(arr, root, rtp, st);
    }

    

    public static void printKNodesFar(Node node, int data, int k){
        ArrayList<Node> arr = nodeToRootPath(node, data);

        for(int i=0; i<arr.size(); i++){
            printKLevelsDown(arr.get(i), k-i, i==0? null : arr.get(i-1));
        }
    }

    public static void printKLevelsDown(Node node, int k, Node blocker){
        if(node == null || k<0 || node == blocker){
            return;
        }
        if(k == 0){
            System.out.print(node.data + " ");
            return;
        }
        printKLevelsDown(node.left, k-1, blocker);
        printKLevelsDown(node.right, k-1, blocker);
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data){
        if(node == null){
            return null;
        }

        if(node.data == data){
            ArrayList<Node> arr = new ArrayList<>();
            arr.add(node);
            return arr;
        }

        ArrayList<Node> left = nodeToRootPath(node.left, data);
        if(left != null){
            left.add(node);
            return left;
        }

        ArrayList<Node> right = nodeToRootPath(node.right, data);
        if(right != null){
            right.add(node);
            return right;
        }

        return null;
    }

    public static void constructBinaryTree(Integer[] arr, Node root, Pair rootPair, Stack<Pair> st){
        st.add(rootPair);
        int idx = 0;

        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    Node ln = new Node(arr[idx], null, null);
                    top.node.left = ln;
                    Pair lp = new Pair(ln, 1);
                    st.push(lp);
                }else{
                    top.node.left = null;
                }
                top.state++;
            }else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    Node rn = new Node(arr[idx], null, null);
                    top.node.right = rn;
                    Pair rp = new Pair(rn, 1);
                    st.push(rp);
                }else{
                    top.node.right = null;
                }
                top.state++;
            }else{
                st.pop();
            }
        }
    }
}
