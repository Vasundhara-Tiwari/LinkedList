package linkedLists;

public class SinglyLinkedList {
    public ListNode head;
    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public  void display(){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.data+"->");
            current=current.next;
        }
        System.out.println("null");
    }

    public int size(){
        if(head == null)
            return 0;
        int count = 0;
        ListNode current = head;
        while(current!=null){
            count++;
            current=current.next;
        }
        return count;
    }

    public void insertAtBeginning(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            head=newNode;
            return;
        }
        ListNode current = head;
        while (current.next!=null){
            current=current.next;
        }
        current.next=newNode;
    }

    public ListNode deleteFirst(){
        if(head==null){
            return null;
        }
        ListNode temp = head;
        head=head.next;
        temp.next=null;
        return temp;
    }

    public ListNode deleteLast(){
        if(head==null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next!=null){
            previous=current;
            current=current.next;
        }
        previous.next=null;
        return current;
    }

    public ListNode getNthNodeFromEnd(int n){
        if(head == null){
            return null;
        }
        if(n<=0){
            throw  new IllegalArgumentException("Invalid value of n = "+n);
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while (count<n){
            if(refPtr==null){
                throw new IllegalArgumentException(n + "is greater than teh number of nodes in the list");
            }
            refPtr=refPtr.next;
            count++;
        }
        while (refPtr!=null){
            refPtr=refPtr.next;
            mainPtr=mainPtr.next;
        }
        return mainPtr;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        //ListNode current = head;
        System.out.println("Linked list 1:");
        sll.display();
        System.out.println(sll.size());
        sll.insertAtBeginning(5);
        sll.insertAtBeginning(20);
        sll.display();

        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertAtBeginning(11);
        sll2.insertAtBeginning(8);
        sll2.insertAtBeginning(1);
        System.out.println("Linked list 2:");
        sll2.display();

        sll2.insertAtEnd(10);
        System.out.println("After insertion at end of the singly linked list");
        sll2.display();

        System.out.println("Deleting the first node");
        System.out.println(sll2.deleteFirst().data);
        System.out.println("Deleting the last node");
        System.out.println(sll2.deleteLast().data);
        System.out.println("After deletion");
        sll2.display();

    }
}
