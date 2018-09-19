package LinkedList;

public class NodeWithRandomPointer {
    int data;
    NodeWithRandomPointer next;
    NodeWithRandomPointer random;

    public NodeWithRandomPointer(int data, NodeWithRandomPointer next, NodeWithRandomPointer random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }
}