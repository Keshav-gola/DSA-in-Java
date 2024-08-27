package Java;

public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    
    public void addFirst(int data){
        //step 1 = create new Node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step 2 - newNode next = head
        newNode.next = head;
        //step3 - head = newNode
        head = newNode;
    }
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean checkPalindrome(){
        if(head == null || head.next != null){
            return true;
        }
        //step1 - find mid
        Node midNode = findMid(head);

        //step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        //step3 - check left half & right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public void deletNthfromEnd(int n){
        if(n == size){
            head = head.next;
            return;
        }
        int i = 1; 
        int iTofind = size -n;
        Node prev = head;
        while(i < iTofind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public int removeFirst(){
        if(size == 0){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public int removeLast(){
        if(size == 0){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node temp = head;
        for(int i = 0; i<size-2; i++){
            temp = temp.next;
        }
        int val = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;

    }
    public void print(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }
    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i< idx-1){
            temp = temp.next;
            i++;
        }

        //i = idx-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int search(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int recSerch(int key){
        return helper(head, key);
    } 
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    } 
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //mid node
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        //left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    } 
    public void ZigZag(){
        //Mid 
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //Reverse
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //alternative
        Node LHead = head;
        Node RHead = prev;
        Node nextL,nextR;
        while(LHead != null && RHead != null){
            nextL = LHead.next;
            LHead.next = RHead;
            nextR = RHead.next;
            RHead.next = nextL;

            LHead = nextL;
            RHead = nextR;
        }
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        // ll.addFirst(1);
        // ll.addFirst(1);
        // ll.addLast(2);  
        // ll.addLast(2); 
        // ll.addLast(1);
        // ll.addLast(1);
        // ll.print();
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // int idx = ll.search(3);
        // System.out.println(idx);
        // int recIdx = ll.recSerch(3);
        // System.out.println(recIdx);
        // ll.reverse();
        // ll.print();
        // ll.deletNthfromEnd(2);
        // ll.print();
        // System.out.println(ll.checkPalindrome());

        // LinkedList ll2 = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);    
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        ll.print(); 
        ll.ZigZag();
        ll.print();

        
    }
}
