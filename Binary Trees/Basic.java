import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Basic{
    
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right =right;
        }
    }

    public  static class Pair{
        Node node;
        int state;

        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null}; //? pre-order

        Integer[] arr2 = {50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null}; //? pre-order

        //! no child ==> null
        //! 1 --> left  child
        //! 2 --> right child
        //! 3 --> pop

        Node root = new Node(arr[0], null, null);
        Pair rootPair = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        constructBinaryTree(arr, root, rootPair, st);

        displayBinaryTree(root);

        System.out.println("Size of tree = " + size(root));
        System.out.println("Sum of tree = " + sum(root));
        System.out.println("Max of tree = " + max(root));
        System.out.println("Height of tree = " + height(root));

        System.out.print("PreOrder = ");
        preOrder(root);

        System.out.print("\nInOrder = ");
        inOrder(root);

        System.out.print("\nPostOrder = ");
        postOrder(root);

        Node root2 = new Node(arr2[0], null, null);
        Pair rootPair2 = new Pair(root2, 1);
        Stack<Pair> st2 = new Stack<>();
        constructBinaryTree(arr2, root2, rootPair2, st2);
        System.out.println("\n");
        displayBinaryTree(root2);

        System.out.println("\n Level Order Traversal: ");
        levelOrderTraversal(root2);

        preInPostOrderIterative(root);

        System.out.println(find(root, 79));
        System.out.println(nodeToRootPath(root, 30));
        printKLevelsDown(root, 2);
        
    }
    

    public static void printKLevelsDown(Node node, int k){
        if(node == null || k<0){
            return;
        }

        if(k == 0){
            System.out.print(node.data + " ");
            return;
        }

        printKLevelsDown(node.left, k-1);
        printKLevelsDown(node.right, k-1);
    }

    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }

        if(node.data == data){
            return true;
        }

        boolean left = find(node.left, data);
        if(left == true){
            return true;
        }

        boolean right = find(node.right, data);
        if(right == true){
            return true;
        }

        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node == null){
            return null;
        }

        if(node.data == data){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(data);
            return arr;
        }

        ArrayList<Integer> left = nodeToRootPath(node.left, data);
        if(left != null){
            left.add(node.data);
            return left;
        }

        ArrayList<Integer> right = nodeToRootPath(node.right, data);
        if(right != null){
            right.add(node.data);
            return right;
        }

        return null;

    }

    public static void levelOrderTraversal(Node node){
        //! 3 steps
        //? step 1: Remove
        //? step 1: Print
        //? step 1: add children

        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);

        while(!mq.isEmpty()){
            int count = mq.size();
            for(int i=0; i<count; i++){
                node = mq.remove();
                System.out.print(node.data + " ");

                if(node.left != null){
                    mq.add(node.left);
                }
                if(node.right != null){
                    mq.add(node.right);
                }
            }
            System.out.print("\n");
        }
    }

    public static int size(Node node){
        if(node == null){
            return 0;
        }
        int numberOfLeftNodes = size(node.left);
        int numberOfRightNodes = size(node.right);
        return numberOfLeftNodes + numberOfRightNodes + 1;
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }

        int sumLeft = sum(node.left);
        int sumRight = sum(node.right);

        return sumLeft + sumRight + node.data;
    }

    public static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }

        int leftMax = max(node.left);
        int rightMax = max(node.right);

        return Math.max(leftMax, Math.max(rightMax, node.data));
    }

    public static int height(Node node){
        if(node == null){
            return -1;
            //? -1 for edges
            //?  0 for nodes
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void displayBinaryTree(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left==null ? "." : node.left.data + "";
        str += " <-- " + node.data + " --> ";
        str += node.right==null ? "." : node.right.data + "";

        System.out.println(str);

        displayBinaryTree(node.left);
        displayBinaryTree(node.right);
    }

    public static void preInPostOrderIterative(Node node){
        String preOrder = "";
        String inOrder = "";
        String postOrder = "";

        Stack<Pair> st = new Stack<>();
        Pair rtp = new Pair(node, 1);
        st.push(rtp);

        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.state == 1){
                preOrder += top.node.data + " ";

                if(top.node.left != null){
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }
            }else if(top.state == 2){
                inOrder += top.node.data + " ";

                if(top.node.right != null){
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }
            }else{
                postOrder += top.node.data + " ";
                st.pop();
            }
            top.state++;
        }
        System.out.println("preOrder = " + preOrder);
        System.out.println("inOrder = " + inOrder);
        System.out.println("postOrder = " + postOrder);
    }

    public static void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void constructBinaryTree(Integer[] arr, Node root, Pair rootPair, Stack<Pair> st){
        st.push(rootPair);

        int idx = 0;
        while (!st.isEmpty()) {
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