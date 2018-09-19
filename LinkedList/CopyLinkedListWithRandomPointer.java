package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithRandomPointer {
    public static void main(String[] args) {
        NodeWithRandomPointer head = new NodeWithRandomPointer(1,null,null);
        head.next = new NodeWithRandomPointer(2, null, null);
        head.next.next = new NodeWithRandomPointer(3,null,null);
        head.next.next.next = new NodeWithRandomPointer(4,null,null);

        head.random = head.next.next.next; // 1->4
        head.next.random = head; //2->1
        head.next.next.random = head.next; // 3 -> 2
        head.next.next.next.random = head.next.next; //4->3;

        printList(head);
        System.out.println();
        System.out.println();

        NodeWithRandomPointer head1 = copyWithRandom(head);
        printList(head1);

    }

    private static void printList(NodeWithRandomPointer head) {

        NodeWithRandomPointer current = head;
        while(current != null){
            System.out.println("Current Node = "+current.data+" Next Node = "+current.next+" Random Pointer = "+current.random.data);
            current = current.next;
        }

    }

    private static NodeWithRandomPointer copyWithRandom(NodeWithRandomPointer head) {
        if(head == null){
            return head;
        }

        HashMap<NodeWithRandomPointer,NodeWithRandomPointer> hMap = new HashMap<>();
        NodeWithRandomPointer currentNode = head;

        while(currentNode != null){
            NodeWithRandomPointer newNode = new NodeWithRandomPointer(currentNode.data,null,null);
            hMap.put(currentNode,newNode);
            currentNode = currentNode.next;
        }

        NodeWithRandomPointer newListHead = null;
        for(Map.Entry<NodeWithRandomPointer,NodeWithRandomPointer> entry : hMap.entrySet()){
            NodeWithRandomPointer node = entry.getValue();
            node.next = hMap.get(entry.getKey().next);
            node.random = hMap.get(entry.getKey().random);

            if(newListHead == null){
                newListHead = node;

            }
        }

        return newListHead;
    }
}
