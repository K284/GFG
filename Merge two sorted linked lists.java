/*
Merge two sorted linked lists
Difficulty: MediumAccuracy: 62.91%Submissions: 169K+Points: 4
Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the sorted merged list.

Examples:

Input: head1 = 5 -> 10 -> 15 -> 40, head2 = 2 -> 3 -> 20
Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
Explanation:

Input: head1 = 1 -> 1, head2 = 2 -> 4
Output: 1 -> 1 -> 2 -> 4
Explanation:

Constraints:
1 <= no. of nodes<= 103
0 <= node->data <= 105
*/
class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        if(head1==null) return head2;
        if(head2==null) return head1;
        
        if(head1.data<=head2.data){
            head1.next = sortedMerge(head1.next,head2);
            return head1;
        }
        else{
            head2.next = sortedMerge(head1,head2.next);
            return head2;
        }
    }
}
