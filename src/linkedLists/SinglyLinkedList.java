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
    }
}
