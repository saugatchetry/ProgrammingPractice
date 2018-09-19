package LinkedList;

public class OddEvenNodesTogether {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.next = new Node(1, null);
        head.next.next = new Node(1, null);
        head.next.next.next = new Node(2, null);
        head.next.next.next.next = new Node(3, null);
        printList(head);
        Node newHead = oddEvenNode(head);
        printList(newHead);
    }

    private static Node oddEvenNode(Node head) {
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }


    private static void printList(Node head) {
        while(head != null){
            System.out.print(head.data+" -> ");
            head = head.next;
        }
        System.out.print("null\n");
    }
}
