/*
Rotate a Linked List
Difficulty: MediumAccuracy: 39.95%Submissions: 261K+Points: 4
Given the head of a singly linked list, your task is to left rotate the linked list k times.

Examples:

Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
Output: 50 -> 10 -> 20 -> 30 -> 40
Explanation:
Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40

Input: head = 10 -> 20 -> 30 -> 40 , k = 6
Output: 30 -> 40 -> 10 -> 20 
 
Constraints:

1 <= number of nodes <= 105
0 <= k <= 109
0 <= data of node <= 109
*/
class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        if(head==null || k==0)
            return head;
            
            Node current = head;
            int length=1;
            
            while(current.next!=null){
                current = current.next;
                length++;
            }
            
            k=k%length;
            if(k==0) return head;
            
            current.next=head;
            current=head;
            
            for(int i=1;i<k;i++){
                current = current.next;
            }
            head = current.next;
            current.next=null;
            return head;
    }
    
}
