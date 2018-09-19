package LinkedList;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.next = new Node(1, null);
        head.next.next = new Node(1, null);
        head.next.next.next = new Node(2, null);
        head.next.next.next.next = new Node(3, null);

        printList(head);

        int n = 3;

        Node newHead = removeNthNodeFromEnd(head,n);
        printList(newHead);
    }

    private static Node removeNthNodeFromEnd(Node head, int n) {
        Node start = new Node(0,null);
        Node slowPtr = start;
        Node fastPtr = head;
        slowPtr.next = head;

        while(n > 0){
            fastPtr = fastPtr.next;
            n--;
        }

        while(fastPtr != null){
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }

        slowPtr.next = slowPtr.next.next;
        return start.next;
    }

    private static void printList(Node head) {
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data+"->");
            currentNode = currentNode.next;
        }
        System.out.print("null\n");
    }
}
