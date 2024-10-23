/*
Find the Sum of Last N nodes of the Linked List
Difficulty: EasyAccuracy: 61.47%Submissions: 51K+Points: 2
Given a single linked list, calculate the sum of the last n nodes.

Note: It is guaranteed that n <= number of nodes.

Examples:

Input: Linked List: 5->9->6->3->4->10, n = 3

Output: 17
Explanation: The sum of the last three nodes in the linked list is 3 + 4 + 10 = 17.
Input: Linked List: 1->2, n = 2

Output: 3
Explanation: The sum of the last two nodes in the linked list is 2 + 1 = 3.
Constraints:
1 <= number of nodes, n <= 105
1 <= node->data <= 103
*/
// Step 1: Count the total number of nodes in the list
        int totalNodes = 0;
        Node temp = head;
        
        while (temp != null) {
            totalNodes++;
            temp = temp.next;
        }
        
        // Step 2: Calculate how many nodes we need to skip
        int skipCount = totalNodes - n;
        
        // Step 3: Move the pointer to the point where the last n nodes start
        temp = head;
        for (int i = 0; i < skipCount; i++) {
            temp = temp.next;
        }
        
        // Step 4: Sum the last n nodes
        int sum = 0;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        
        return sum;
