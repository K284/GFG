/*
XOR Linked List
Difficulty: MediumAccuracy: 58.15%Submissions: 29K+Points: 4
An ordinary Doubly Linked List requires space for two address fields to store the addresses of previous and next nodes. A memory-efficient version of the Doubly Linked List can be created using only one space for the address field with every node. This memory-efficient Doubly Linked List is called XOR Linked List or Memory Efficient as the list uses bit-wise XOR operation to save space for one address.

Given a stream of data of size N for the linked list, your task is to complete the function insert() and getList(). The insert() function pushes (or inserts at the beginning) the given data in the linked list and the getList()  function returns the linked list as a list.

Note:

A utility function XOR() takes two Node pointers to get the bit-wise XOR of the two Node pointers. Use this function to get the XOR of the two pointers.
The driver code prints the returned list twice, once forward and once backwards.
Examples:

Input:
LinkedList: 9<->5<->4<->7<->3<->10

Output:
10 3 7 4 5 9
9 5 4 7 3 10
Input:
LinkedList: 58<->96<->31

Output:
31 96 58
58 96 31
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= number of nodes, data of nodes <= 105
*/
class Solution {
    // function should insert the data to the front of the list
    static Node insert(Node head, int data) {
        // Code Here.
        Node x=new Node(data);
        x.npx=head;
        return x;
    }

    // function to print the linked list
    static ArrayList<Integer> getList(Node head) {
        // Code Here.
        ArrayList<Integer> l1=new ArrayList<>();
        Node x=head;
        while(x!=null){
            l1.add(x.data);
            x=x.npx;
        }
        return l1;
    }
}
