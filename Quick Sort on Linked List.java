/*
Quick Sort on Linked List
Difficulty: MediumAccuracy: 71.8%Submissions: 30K+Points: 4
You are given a Linked List. Sort the given Linked List using quicksort. 

Examples:

Input: Linked list: 1->6->2
Output: 1->2->6

Explanation:
After sorting the nodes, we have 1, 2 and 6.
Input: Linked list: 1->9->3->8
Output: 1->3->8->9

Explanation:
After sorting the nodes, we have 1, 3, 8 and 9. 
Constraints:
1<= size of linked list <= 105
*/
class GfG {
    public static Node getTail(Node node) {
        if (node == null) return null;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
    public static Node concatenate(Node firstHead, Node pivot, Node secondHead) {
        Node head = firstHead;

        if (firstHead != null) {
            Node tail = getTail(firstHead);
            tail.next = pivot;
        } else {
            head = pivot;
        }

        pivot.next = secondHead;
        return head;
    }
    private static Node[] partition(Node start, Node end) {
        Node pivot = start;
        Node firstHead = null, firstTail = null;
        Node secondHead = null, secondTail = null;
        Node current = start.next;
        while(current != end.next){
            if(current.data < pivot.data){
                if(firstHead == null){
                    firstHead = current;
                    firstTail = current;
                }
                else {
                    firstTail.next = current;
                    firstTail = current;
                }
            }
            else {
                if(secondHead == null){
                    secondHead = current;
                    secondTail = current;
                }
                else {
                    secondTail.next = current;
                    secondTail = current;
                }
            }
            current = current.next;
        }
        if(firstTail !=null) firstTail.next = null;
        if(secondTail !=null) secondTail.next = null;
        return new Node[]{firstHead, pivot, secondHead};
    }
    public static Node quickSortFunc(Node start, Node end) {
        if(start == null || start == end) return start;
        Node[] partitioned = partition(start, end);
        Node firstHead = partitioned[0];
        Node pivot = partitioned[1];
        Node secondHead = partitioned[2];
        
        firstHead = quickSortFunc(firstHead, getTail(firstHead));
        secondHead = quickSortFunc(secondHead, getTail(secondHead));
        
        return concatenate(firstHead, pivot, secondHead);
        
    }
    public static Node quickSort(Node node) {
        // Your code here
        node = quickSortFunc(node, getTail(node));
        return node;
    }
}
