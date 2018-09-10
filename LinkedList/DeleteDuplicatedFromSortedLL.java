package LinkedList;

public class DeleteDuplicatedFromSortedLL {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.next = new Node(1, null);
        head.next.next = new Node(1, null);
        head.next.next.next = new Node(2, null);
        head.next.next.next.next = new Node(3, null);

        printList(head);

        Node head1 = deleteDuplicate(head);

        printList(head1);

    }

    private static Node deleteDuplicate(Node head) {
        Node currentNode = head;
        Node temp;
        while(currentNode != null && currentNode.next != null){
            if(currentNode.data == currentNode.next.data){
                temp = currentNode.next.next;
                if(temp == null){
                    currentNode.next = temp;
                    break;
                }
                currentNode.next = temp;
            }

            if(currentNode.data != currentNode.next.data){
                currentNode = currentNode.next;
            }
        }

        return head;
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
