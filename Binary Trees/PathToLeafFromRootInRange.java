import java.util.Stack;

public class PathToLeafFromRootInRange {
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

    public static class DiaPair{
        int ht;
        int dia;
    }

    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null}; //? pre-order

        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        constructBinaryTree(arr, root, rtp, st);

        System.out.println("\nDiameter1 = " + diameter1(root));

        int lowSum = 0;
        int highSum = 407;
        pathToLeaf(root, "", 0, lowSum, highSum);

        Node leftCloneRoot = createLeftCloneTree(root);
        displayBinaryTree(leftCloneRoot);
        preOrder(leftCloneRoot);

        System.out.print("\n");
        Node transformBackRoot = transformBackFromLeftCloneTree(leftCloneRoot);
        preOrder(transformBackRoot);

        System.out.print("\n");
        printSingleChildNodes(root, null);

        System.out.print("\n");
        Node removedLeavesRoot = removeLeaves(root);
        preOrder(removedLeavesRoot);

        
    }

    public static int height(Node node){
        if(node == null){
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static DiaPair diameter2(Node node){
        if(node == null){
            DiaPair bp = new DiaPair();
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }

        DiaPair lp = diameter2(node.left);
        DiaPair rp = diameter2(node.right);

        DiaPair mp = new DiaPair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;
        mp.dia = Math.max(lp.ht + rp.ht + 2, Math.max(lp.dia, rp.dia));

        return mp;
    }

    public static int diameter1(Node node){
        if(node == null){
            return 0;
        }
        
        int ld = diameter1(node.left);                       //? max distance between two nodes on LHS
        int rd = diameter1(node.right);                      //? max distance between two nodes on RHS
        int f = height(node.left) + height(node.right) + 2;  //? max distance between left's deepest and right's deepest

        int dia = Math.max(f, Math.max(ld, rd));
        return dia;
    }

    public static Node removeLeaves(Node node){
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null){
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }

    public static void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static Node transformBackFromLeftCloneTree(Node node){
        if(node == null){
            return null;
        }

        Node left = transformBackFromLeftCloneTree(node.left.left);
        Node right = transformBackFromLeftCloneTree(node.right);

        node.left = left;
        node.right = right;

        return node;
    }

    public static void printSingleChildNodes(Node node, Node parent){
        
        if(node == null){
            return;
        }

        if(parent != null && parent.left == node && parent.right == null){
            System.out.print(node.data + " ");
        }else if(parent != null && parent.right == node && parent.left == null){
            System.out.print(node.data + " ");
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static Node createLeftCloneTree(Node node){
        if(node == null){
            return null;
        }

        Node leftCloneRoot = createLeftCloneTree(node.left);
        Node rightCloneRoot = createLeftCloneTree(node.right);
        
        Node copyNode = new Node(node.data, leftCloneRoot, null);
        node.left = copyNode;
        node.right = rightCloneRoot;

        return node;
    }

    public static void pathToLeaf(Node node, String path, int sum, int lo, int hi){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            sum += node.data;
            if(sum >= lo && sum <= hi){
                System.out.println(path + node.data);
            }
            return;
        }

        pathToLeaf(node.left, path + node.data + " ", sum + node.data, lo, hi);
        pathToLeaf(node.right, path + node.data + " ", sum + node.data, lo, hi);
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
