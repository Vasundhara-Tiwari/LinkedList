package linkedLists;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;
    private class ListNode
    {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data)
        {
            this.data=data;
        }
    }
    public DoublyLinkedList()
    {
        this.head=null;
        this.tail=null;
        this.length=0;
    }
}
