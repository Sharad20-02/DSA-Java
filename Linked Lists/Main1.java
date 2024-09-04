public class Main1{

    public static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        void addLast(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if(size == 0){
                head = temp;
                tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size(){
            return size;
        }

        public void display(){
            Node curr = head;
            while(curr != null){
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.print("\n");
        }

        public void removeFirst(){
            if(size == 0){
                System.out.println("Empty Linked List");
                return;
            }else if(size == 1){
                head= tail = null;
                size = 0;
            }else{                
                head = head.next;
                size--;
            }
        }

        public int getFirst(){
            if(size == 0){
                System.out.println("Empty Linked List");
                return -1;
            }else{
                return head.data;
            }
        }

        public int getLast(){
            if(size == 0){
                System.out.println("Empty Linked List");
                return -1;
            }else{
                return tail.data;
            }
        }

        public int getAt(int idx){
            if(size == 0){
                System.out.println("Empty Linked List");
                return -1;
            }else{
                if(idx >= size || idx < 0){
                    System.out.println("Invalid Arguments");
                    return -1;
                }else{
                    int i=0;
                    Node curr = head;
                    while(i<idx){
                        curr = curr.next;
                        i++;
                    }
                    return curr.data;
                }
            }
        }

        public void addFirst(int val){
            Node temp = new Node();
            temp.data = val;

            if(size == 0){
                temp.next = null;
                head = tail = temp;
            }else{
                temp.next = head;
                head = temp;
            }

            size++;
        }

        public void addAt(int idx, int val){
            if(idx >=size || idx < 0){
                System.out.println("Invalid arguments");
                return;
            }else if(idx == 0){
                addFirst(val);
            }else if(idx == size - 1){
                addLast(val);
            }
            else{
                Node temp = new Node();
                temp.data = val;

                Node prev = head;
                for(int i=0; i<idx-1; i++){
                    prev = prev.next;
                }

                temp.next = prev.next;
                prev.next = temp;

                size++;
            }
        }

        public void removeLast(){
            if(size == 0){
                System.out.println("Empty Linked List");
                return;
            }else if(size == 1){
                head = tail = null;
                size = 0;
                return;
            }else{
                Node temp = head;
                for(int i=0; i<size-2; i++){
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }

            size--;

        }

        private Node getNodeAt(int idx){
            if(size == 0){
                System.out.println("Empty Linked List");
                return null;
            }else{
                if(idx < 0 || idx >= size){
                    System.out.println("Invalid arguments");
                    return null;
                }else{
                    Node temp = head;
                    for(int i=0; i<idx; i++){
                        temp = temp.next;
                    }
                    return temp;
                }

            }
            

        }

        public void reverseDI(){
            int li = 0;
            int ri = size - 1;

            while(li < ri){
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }

        public void reversePI(){
            if(size == 0){
                System.out.println("Empty Linked List");
                return;
            }else if(size == 1){
                return;
            }else{
                Node prev = null;
                Node curr = head;

                while(curr != null){
                    Node temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                }
                Node temp = head;
                head = tail;
                tail = temp;
            }
        }

        public void removeAt(int idx){
            if(size == 0){
                System.out.println("Empty Linked List");
                return;
            }else{
                if(idx < 0 || idx >= size){
                    System.out.println("Invalid Arguments");
                    return;
                }else{
                    if(idx == 0){
                        removeFirst();
                    }else if(idx == size - 1){
                        removeLast();
                    }else{
                        Node prev = null;
                        Node curr = head;
                        for(int i=0; i<idx; i++){
                            prev = curr;
                            curr = curr.next;
                        }

                        prev.next = curr.next;
                        size--;
                    }
                }
            }
        }

        public int kthFromLast(int k){
            Node fast = head;
            Node slow = head;

            for(int i=0; i<k; i++){
                fast = fast.next;
            }

            while(fast != tail){
                fast = fast.next;
                slow = slow.next;
            }

            return slow.data;
        }

        public int mid(){
            Node fast = head;
            Node slow = head;

            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            
            return slow.data;
        }

        public static LinkedList mergeTwoSorteLinkedLists(LinkedList l1, LinkedList l2){
            Node node1 = l1.head;
            Node node2 = l2.head;

            LinkedList list = new LinkedList();

            while(node1 != null && node2 != null){
                if(node1.data < node2.data){
                    list.addLast(node1.data);
                    node1 = node1.next;
                }else{
                    list.addLast(node2.data);
                    node2 = node2.next;
                }
            }

            while(node1 != null){
                list.addLast(node1.data);
                node1 = node1.next;
            }

            while(node2 != null){
                list.addLast(node2.data);
                node2 = node2.next;
            }
            return list;
        }

        public static Node midNode(Node head, Node tail){
            Node fast = head;
            Node slow = head;

            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        public static LinkedList mergeSort(Node head, Node tail){
            if(head == tail){
                LinkedList list = new LinkedList();
                list.addLast(head.data);
                return list;
            }

            Node mid = midNode(head, tail);
            LinkedList fsh = mergeSort(head, mid);
            LinkedList ssh = mergeSort(mid.next, tail);
            
            return mergeTwoSorteLinkedLists(fsh, ssh);

        }
    }


    public static void main(String[] args) {
        
    }
}