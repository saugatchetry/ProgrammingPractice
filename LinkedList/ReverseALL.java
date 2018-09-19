package LinkedList;

public class ReverseALL {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = new Node(5, null);

        printList(head);
        
        Node reversed = reverseList(head);

        printList(reversed);

        Node reversedIterative = reverseListIterative(reversed);

        printList(reversedIterative);
    }

    private static Node reverseListIterative(Node head) {

        if(head == null){
            return null;
        }

        else if(head.next == null){
            return head;
        }

        Node currentNode = head;
        Node previousNode = null;
        Node nextNode = null;

        while(currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    private static Node reverseList(Node currentNode) {

        if(currentNode.next == null){
            return currentNode; //5.next == null, hence return 5 to 4.
        }

        Node temp = reverseList(currentNode.next); //temp == 5
        currentNode.next.next = currentNode; // current = 4; 4.next.next = (5).next = 4
        currentNode.next = null; //4.next = null
        return temp; // return 5;
    }


    private static void printList(Node reveresedNode) {
        Node currentNode = reveresedNode;
        while(currentNode != null){
            System.out.print(currentNode.data+"->");
            currentNode = currentNode.next;
        }
        System.out.print("null\n");
    }
}
