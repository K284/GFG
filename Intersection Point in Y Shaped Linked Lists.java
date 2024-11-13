/*
Intersection Point in Y Shaped Linked Lists
Difficulty: MediumAccuracy: 44.67%Submissions: 287K+Points: 4
Given two singly linked lists, return the point where two linked lists intersect.

Note: If the linked lists do not merge at any point, return -1.

Examples:

Input: Linked list 1: 4->4->4->4->4, Linked list 2: 4->4->4
 
Output: 4
Explanation: From the above image, it is clearly seen that the common part is 4->4 whose starting point is 4.

Input: Linked list 1: 4->1->8->4->5, Linked List 2: 5->6->1->8->4->5
 
Output: 8
Explanation: From the above image, it is clearly seen that the common part is 8->4->5 whose starting point is 8.
Input: Linked list 1: 1->2->3, Linked list 2: 4->5->6
Output: -1
Explanation: There is no common part, so there is no interaction point.
Try to solve the problem without using any extra space.

Constraints:
2 ≤ size of first linkedist + size of second linkedlist ≤ 2*105
-10000 ≤ data of nodes ≤ 10000
*/
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2) {
        // code here
        // Step 1: Calculate the lengths of both linked lists
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        // Step 2: Calculate the difference in lengths
        int diff = Math.abs(len1 - len2);

        // Step 3: Align the starting points of both lists
        if (len1 > len2) {
            head1 = advanceBy(head1, diff);
        } else {
            head2 = advanceBy(head2, diff);
        }

        // Step 4: Traverse both lists together to find the intersection point
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1.data; // Intersection point found
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        // No intersection point found
        return -1;
    }

    // Helper function to get the length of a linked list
    private int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // Helper function to advance the list by 'n' nodes
    private Node advanceBy(Node head, int n) {
        while (n > 0 && head != null) {
            head = head.next;
            n--;
        }
        return head;
    }
}
