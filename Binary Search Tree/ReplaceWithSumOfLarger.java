import java.util.ArrayList;
import java.util.Stack;

public class ReplaceWithSumOfLarger {

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

    public static class ITPair{
        Node node;
        int state;

        public ITPair(Node node, int state){
            this.state = state;
            this.node = node;
        }
    }

    public static int sum = 0;

    public static void main(String[] args) {
        int[] arr = {12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
        Node root = constructBst(arr, 0, arr.length-1);
        display(root);

        // replaceWithSumOfLarger(root);
        // System.out.println("\n");
        // display(root);

        System.out.println("\n" + lowestLevelCommonAncestor(root, 12, 40));
        
        printInRange(root, 27, 72);

        // System.out.println("\n");
        // targetSumPair(root, root, 100);

        ArrayList<Integer> list = new ArrayList<>();
        travelAndFill(root, list);
        int targetSum = 100;
        System.out.println("\n");
        int li = 0;
        int ri = list.size()-1;
        while(li<ri){
            int sum = list.get(li) + list.get(ri);
            if(sum < targetSum){
                li++;
            }else if(sum > targetSum){
                ri--;
            }else{
                System.out.println(list.get(li) + " <==> " + list.get(ri));
                li++;
                ri--;
            }
        }
    }

    public static void bestApproach(Node node, int tar){
        Stack<ITPair> lst = new Stack<>();
        Stack<ITPair> rst = new Stack<>();

        lst.add(new ITPair(node, 0));
        rst.add(new ITPair(node, 0));

        Node left = getNextFromNormalInorder(lst);
        Node right = getNextFromReverseInorder(rst);

        while(left.data < right.data){
            if(left.data+right.data < tar){
                left = getNextFromNormalInorder(lst);
            }else if(left.data+right.data > tar){
                right = getNextFromReverseInorder(rst);
            }else{
                System.out.println(left.data + " <==> " + right.data);
                left = getNextFromNormalInorder(lst);
                right = getNextFromReverseInorder(rst);
            }
        }

    }

    public static Node getNextFromNormalInorder(Stack<ITPair> st){
        while(!st.isEmpty()){
            ITPair top = st.peek();

            if(top.state == 0){
                if(top.node.left != null){
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;
            }else if(top.state == 1){
                if(top.node.right != null){
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;
                return top.node;
            }else{
                st.pop();
            }
        }
        return null;
    }

    public static Node getNextFromReverseInorder(Stack<ITPair> st){
        while(!st.isEmpty()){
            ITPair top = st.peek();

            if(top.state == 0){
                if(top.node.right != null){
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;
            }else if(top.state == 1){
                if(top.node.left != null){
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;
                return top.node;
            }else{
                st.pop();
            }
        }
        return null;
    }

    public static void printInRange(Node node, int lo, int hi){
        if(node == null){
            return;
        }

        if(node.data > hi){
            printInRange(node.left, lo, hi);
        }else if(node.data < lo){
            printInRange(node.right, lo, hi);
        }else{
            printInRange(node.left, lo, hi);
            System.out.print(node.data + " ");
            printInRange(node.right, lo, hi);
        }
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

    public static void travelAndFill(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }
        travelAndFill(node.left, list);
        list.add(node.data);
        travelAndFill(node.right, list);
    }

    public static void targetSumPair(Node root, Node node, int targetSum){

        if(node == null){
            return;
        }

        targetSumPair(root, node.left, targetSum);
        int comp = targetSum - node.data;
        if(node.data < comp){
            if(find(root, comp) == true){
                System.out.println(node.data + " <==> " + comp);
            }
        }
        targetSumPair(root, node.right, targetSum);
    }

    public static int lowestLevelCommonAncestor(Node node, int d1, int d2){

        if(d1<node.data && d2<node.data){
            return lowestLevelCommonAncestor(node.left, d1, d2);
        }else if(d1>node.data && d2>node.data){
            return lowestLevelCommonAncestor(node.right, d1, d2);
        }else{
            return node.data;
        }
    }



    public static void replaceWithSumOfLarger(Node node){
        if(node == null){
            return;
        }

        replaceWithSumOfLarger(node.right);

        //? reverse-inorder
        int temp = node.data;
        node.data = sum;
        sum += temp;

        replaceWithSumOfLarger(node.left);
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
}
