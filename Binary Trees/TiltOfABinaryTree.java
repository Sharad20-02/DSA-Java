import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class TiltOfABinaryTree {
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

    public static class searchPair{
        int max;
        int min;
        boolean isBinary;
        int size;
        Node root;

    }

    public static class balancedPair{
        int ht;
        boolean isBalanced;
    }

    

    static int tilt = 0;
    

    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null}; //? pre-order

        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        constructBinaryTree(arr, root, rtp, st);

        
        tiltOfTree(root);
        System.out.println("Tilt of tree = " + tilt);

        searchPair rsp = isABinaryTree(root);
        System.out.print("\n" + rsp.isBinary + " " + rsp.max + " " + rsp.min + "\n");

        preOrder(root);
        balancedPair rbp = isBalancedTree(root);
        System.out.print("\n" + rbp.isBalanced + " " + rbp.ht);

        searchPair rsp2 = isABinaryTree2(root);
        System.out.print("\n" + rsp2.root.data + " @ " + rsp2.size);

    }

    public static balancedPair isBalancedTree(Node node){
        if(node == null){
            balancedPair bbp = new balancedPair();
            bbp.ht = 0;
            bbp.isBalanced = true;
            return bbp;
        }

        balancedPair lbp = isBalancedTree(node.left);
        balancedPair rbp = isBalancedTree(node.right);

        balancedPair mbp = new balancedPair();
        mbp.ht = Math.max(lbp.ht, rbp.ht) + 1;
        if(Math.abs(lbp.ht - rbp.ht) <= 1 && lbp.isBalanced == true && rbp.isBalanced == true){
            mbp.isBalanced = true;
        }else{
            mbp.isBalanced = false;
        }

        return mbp;

    }

    public static searchPair isABinaryTree2(Node node){
        if(node == null){
            searchPair bsp = new searchPair();
            bsp.isBinary = true;
            bsp.max = Integer.MIN_VALUE;
            bsp.min = Integer.MAX_VALUE;
            bsp.size = 0;
            bsp.root = null;
            return bsp;
        }

        searchPair lsp = isABinaryTree2(node.left);
        searchPair rsp = isABinaryTree2(node.right);

        searchPair msp = new searchPair();
        msp.max = Math.max(node.data, Math.max(lsp.max, rsp.max));
        msp.min = Math.min(node.data, Math.min(lsp.min, rsp.min));
        
        if(node.data >= lsp.max && node.data <= rsp.min && lsp.isBinary == true && rsp.isBinary == true){
            msp.isBinary = true;
        }else{
            msp.isBinary = false;
        }

        if(msp.isBinary){
            msp.root = node;
            msp.size = lsp.size + rsp.size + 1;
        }else if(lsp.size > rsp.size){
            msp.root = lsp.root;
            msp.size = lsp.size;
        }else{
            msp.root = rsp.root;
            msp.size = rsp.size;
        }

        return msp;
    }

    public static searchPair isABinaryTree(Node node){
        if(node == null){
            searchPair bsp = new searchPair();
            bsp.isBinary = true;
            bsp.max = Integer.MIN_VALUE;
            bsp.min = Integer.MAX_VALUE;
            return bsp;
        }

        searchPair lsp = isABinaryTree(node.left);
        searchPair rsp = isABinaryTree(node.right);

        searchPair msp = new searchPair();
        msp.max = Math.max(node.data, Math.max(lsp.max, rsp.max));
        msp.min = Math.min(node.data, Math.min(lsp.min, rsp.min));
        if(node.data >= lsp.max && node.data <= rsp.min && lsp.isBinary == true && rsp.isBinary == true){
            msp.isBinary = true;
        }else{
            msp.isBinary = false;
        }

        return msp;
    }

    public static int tiltOfTree(Node node){
        if(node == null){
            return 0;
        }
        int leftSum = tiltOfTree(node.left);
        int rightSum = tiltOfTree(node.right);

        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.data;
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

    public static void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
