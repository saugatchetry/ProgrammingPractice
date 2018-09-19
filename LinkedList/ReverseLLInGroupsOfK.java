package LinkedList;

public class ReverseLLInGroupsOfK {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = new Node(5, null);

        printList(head);

        int k = 3;
        Node reversed = reverseKGroup(head,k);
        //Node reversed = reverseInGroupsofK(head,k);
        printList(head);
    }

    private static Node reverseInGroupsofK(Node head, int k) {

        Node nextNode = null;
        Node currentNode = head;
        Node previousNode = null;
        int count = 0;

        while(currentNode != null && count < k){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            count++;
        }

        if(nextNode != null){
            head.next = reverseInGroupsofK(nextNode,k);
        }

        return previousNode;
    }


    public static Node reverseKGroup(Node head, int k) {
        if (head == null || head.next == null || k < 2)
            return head;

        int count = 0;
        Node cur = head;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }

        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                Node tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
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
