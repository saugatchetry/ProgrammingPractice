package LinkedList;

public class NthNodeFromLL {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.next = new Node(1, null);
        head.next.next = new Node(1, null);
        head.next.next.next = new Node(2, null);
        head.next.next.next.next = new Node(3, null);

        printList(head);

        int n = 1;

        Node nthNode = findNthNode(head,n);

        System.out.println("Nth node from end = "+nthNode.data);
    }

    private static Node findNthNode(Node head, int n) {
        Node currentNode = head;
        Node slowPtr = head;


        while(n > 0){
            currentNode = currentNode.next;
            n--;
        }


        while(currentNode != null){
            currentNode = currentNode.next;
            slowPtr = slowPtr.next;
        }

        return slowPtr;
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
