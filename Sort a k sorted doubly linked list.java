/*
Sort a k sorted doubly linked list
Difficulty: EasyAccuracy: 67.12%Submissions: 6K+Points: 2
Given a doubly linked list, each node is at most k-indices away from its target position. The problem is to sort the given doubly linked list. The distance can be assumed in either of the directions (left and right).

Examples :

Input: Doubly Linked List : 3 <-> 2 <-> 1 <-> 5 <-> 6 <-> 4 , k = 2
Output: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6

Explanation: After sorting the given 2-sorted list is 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6.
Input: Doubly Linked List : 5 <-> 6 <-> 7 <-> 3 <-> 4 <-> 4 , k = 3
Output: 3 <-> 4 <-> 4 <-> 5 <-> 6 <-> 7

Explanation: After sorting the given 3-sorted list is 3 <-> 4 <-> 4 <-> 5 <-> 6 <-> 7.
Expected Time Complexity: O(n*logk)
Expected Auxiliary Space: O(k)
Constraints:
1 <= number of nodes <= 105
1 <= k < number of nodes
1 <= node->data <= 109
*/
class Solution {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Code here
        if (head == null) return head;

        // Min-Heap to store nodes
        PriorityQueue<DLLNode> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        DLLNode newHead = null, last = null;

        // Step 1: Insert first k+1 elements into the minHeap
        DLLNode current = head;
        for (int i = 0; i <= k && current != null; i++) {
            minHeap.add(current);
            current = current.next;
        }

        // Step 2: Process the heap until all elements are sorted
        while (!minHeap.isEmpty()) {
            // Extract the smallest node from the heap
            DLLNode smallest = minHeap.poll();

            // If this is the first node, set it as the new head
            if (newHead == null) {
                newHead = smallest;
                smallest.prev = null;
                last = newHead;
            } else {
                // Append the smallest node to the sorted list
                last.next = smallest;
                smallest.prev = last;
                last = smallest;
            }

            // Add the next element from the unsorted list into the heap
            if (current != null) {
                minHeap.add(current);
                current = current.next;
            }
        }

        // Make sure the last node's next is null
        last.next = null;

        return newHead;
    }
}
