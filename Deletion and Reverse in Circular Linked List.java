/*
Deletion and Reverse in Circular Linked List
Difficulty: MediumAccuracy: 60.7%Submissions: 45K+Points: 4
Given a Circular Linked List. The task is to delete the given node, key in the circular linked list, and reverse the circular linked list.

Note:

You don't have to print anything, just return the head of the modified list in each function.
Nodes may consist of Duplicate values.
The key may or may not be present.
Examples:

Input: Linked List: 2->5->7->8->10, key = 8

Output: 10->7->5->2 
Explanation: After deleting 8 from the given circular linked list, it has elements as 2, 5, 7, 10. Now, reversing this list will result in 10, 7, 5, 2 & the resultant list is also circular.
Input: Linked List: 1->7->8->10, key = 8

Output: 10->7->1
Explanation: After deleting 8 from the given circular linked list, it has elements as 1, 7,10. Now, reversing this list will result in 10, 7, 1 & the resultant list is also circular.
Input: Linked List: 3->6->4->10, key = 9
Output: 10->4->6->3
Explanation: As there no key present in the list, so simply reverse the list & the resultant list is also circular.
Expected Time Complexity: O(n)
Expected Auxillary Space: O(1)

Constraints:
2 <= number of nodes, key  <= 105
1 <= node -> data <= 105
*/
class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        if (head == null || head.next == head) {
            return head;
        }
        
        Node prev = null;
        Node curr = head;
        Node next = null;
        Node tail = head;
        
        // Traverse the list and reverse pointers
        do {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } while (curr != head);
        
        // Complete the circularity
        head.next = prev;  // the old head's next points to the new tail
        head = prev;  // new head is the previous node
        
        return head;
    }
    
    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        if (head == null) return null;
        
        // Special case: if the head itself holds the key
        if (head.data == key) {
            // If there's only one node in the list
            if (head.next == head) {
                return null;  // the list becomes empty
            }
            
            // Find the last node (to update its next)
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            // Make the next node the new head and adjust the last node's next
            head = head.next;
            last.next = head;
            return head;
        }
        
        // Deletion from the middle or end
        Node curr = head;
        Node prev = null;
        
        do {
            prev = curr;
            curr = curr.next;
            
            if (curr.data == key) {
                prev.next = curr.next;
                break;
            }
        } while (curr != head);
        
        return head;
    }
}
