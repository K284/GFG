/*
Split Linked List Alternatingly
Difficulty: EasyAccuracy: 42.46%Submissions: 22K+Points: 2
Given a singly linked list's head. Your task is to complete the function alternatingSplitList() that splits the given linked list into two smaller lists. The sublists should be made from alternating elements from the original list.
Note: 

The sublist should be in the order with respect to the original list.
Your have to return an array containing the both sub-linked lists.
Examples:

Input: LinkedList = 0->1->0->1->0->1
Output: 0->0->0 , 1->1->1
Explanation: After forming two sublists of the given list as required, we have two lists as: 0->0->0 and 1->1->1.

Input: LinkedList = 2->5->8->9->6
Output: 2->8->6 , 5->9
Explanation: After forming two sublists of the given list as required, we have two lists as: 2->8->6 and 5->9.
Input: LinkedList: 7 
Output: 7 , <empty linked list>
Constraints:
1 <= number of nodes <= 100
1 <= node -> data <= 104
*/
class Solution {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        // code here
        if (head == null) return new Node[]{null, null};

        // Initialize the heads and tails for both lists
        Node aHead = null, bHead = null;
        Node aTail = null, bTail = null;
        Node current = head;
        
        // Boolean to alternate between the two lists
        boolean switchList = true;

        while (current != null) {
            if (switchList) {
                // Add current node to list A
                if (aHead == null) {
                    aHead = current;
                    aTail = current;
                } else {
                    aTail.next = current;
                    aTail = aTail.next;
                }
            } else {
                // Add current node to list B
                if (bHead == null) {
                    bHead = current;
                    bTail = current;
                } else {
                    bTail.next = current;
                    bTail = bTail.next;
                }
            }
            // Alternate the list to add the next node
            switchList = !switchList;
            // Move to the next node in the original list
            current = current.next;
        }

        // Terminate both lists
        if (aTail != null) aTail.next = null;
        if (bTail != null) bTail.next = null;

        // Return the two lists
        return new Node[]{aHead, bHead};
    }
}
