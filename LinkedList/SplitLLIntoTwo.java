package LinkedList;

public class SplitLLIntoTwo {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.next = new Node(2, null);

        //printList(head);

        splitList(head);
    }

    private static void splitList(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;
        Node second_start = head;


        while(fastPtr.next != null && fastPtr.next.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        second_start = slowPtr.next;
        slowPtr.next = null;

        printList(head);
        printList(second_start);
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
