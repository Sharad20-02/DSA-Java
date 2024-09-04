public class Basic{

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        int[] arr = {12, 25, 37, 58, 62, 75, 87};
        Node root = constructBst(arr, 0, arr.length-1);
        display(root);

        addNode(root, 47);
        addNode(root, 68);

        System.out.print("\n");
        display(root);
    }

    public static Node removeNode(Node node, int data){
        if(node == null){
            return null;
        }

        if(data < node.data){
            node.left = removeNode(node.left, data);
        }else if(data > node.data){
            node.right = removeNode(node.right, data);
        }else{
            if(node.left != null && node.right != null){
                //? 2 child
                int leftMax = max(node.left);
                node.data = leftMax;
                node.left = removeNode(node.left, leftMax);
                return node;
            }else if(node.left !=null){
                //? 1 child
                return node.left;
            }else if(node.right != null){
                //? 1 child
                return node.right;
            }else{
                //? 0 child
                return null;
            }
        }
        
        return node;
    }

    public static Node addNode(Node node, int data){
        if(node == null){
            Node newNode = new Node(data, null, null);
            return newNode;
        }

        if(data > node.data){
            node.right = addNode(node.right, data);
        }else if(data < node.data){
            node.left = addNode(node.left, data);
        }else{
            //? nothing to do
        }
        return node;
    }

    public static Node constructBst(int[] arr, int lo, int hi){
        if(lo > hi){
            return null;
        }
        int mid = (lo + hi) / 2;

        int data = arr[mid];
        Node lc = constructBst(arr, lo, mid-1);
        Node rc = constructBst(arr, mid+1, hi);

        Node node = new Node(data, lc, rc);
        return node;
    }

    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left==null ? "." : node.left.data + "";
        str += " <-- " + node.data + " --> ";
        str += node.right==null ? "." : node.right.data + "";

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node){
        if(node == null){
            return -1;
        }

        int lsize = size(node.left);
        int rsize = size(node.right);
        return Math.max(lsize, rsize) + 1;
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }

        int lsum = sum(node.left);
        int rsum = sum(node.right);

        return lsum + rsum + node.data;
    }

    public static int max(Node node){
        while(node.right != null){
            node = node.right;
        }
        return node.data;
    }

    public static int min(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node.data;
    }

    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }

        if(data == node.data){
            return true;
        }else if(data > node.data){
            return find(node.right, data);
        }else{
            return find(node.left, data);
        }
    }
}