package LinkedList;

public class CheckIfLLIsPalindrome {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.next = new Node(1, null);
        head.next.next = new Node(1, null);
        head.next.next.next = new Node(2, null);



        boolean isPalindrome = checkIfPalindrome(head);
        if(isPalindrome){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }
    }

    private static boolean checkIfPalindrome(Node head) {
        Node currentNode = head;
        Node slowPtr = head;
        Node fastPtr = head;
        Node second_head = head;

        while(fastPtr.next != null && fastPtr.next.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        second_head = slowPtr.next;
        slowPtr.next = null;

        Node reversed = reverseList(second_head);

        while(currentNode != null && reversed != null){
            if(currentNode.data != reversed.data){
                return false;
            }
            else{
                currentNode = currentNode.next;
                reversed = reversed.next;
            }
        }
        return true;
    }

    private static Node reverseList(Node currentNode) {

        if(currentNode.next == null){
            return currentNode;
        }

        Node temp = reverseList(currentNode.next);
        currentNode.next.next = currentNode;
        return temp;
    }
}
