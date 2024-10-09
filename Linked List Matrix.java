/*
Linked List Matrix
Difficulty: EasyAccuracy: 67.33%Submissions: 25K+Points: 2
Given a Matrix mat of n*n size. Your task is constructing a 2D linked list representation of the given matrix.

Input: mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output: 

Input: mat = [[23, 28], [23, 28]]
Output:

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)

Constraints:
1 <= mat.size() <=15
1 <= mat[i][j] <=104
*/
// User function Template for Java

/*class Node

class Node
{
   int data;
   Node right,down;

   Node(int data){
       this.data = data;
       right = null;
       down = null;
   }
}
*/
/*Function should return the head of the 2D LL.*/
class Solution {
    static Node construct(int arr[][]) {
        // Add your code here.
        // Base case: if the matrix is empty, return null
        if (arr.length == 0 || arr[0].length == 0) {
            return null;
        }
        
        int n = arr.length;    // number of rows
        int m = arr[0].length; // number of columns

        // Create an array of Node references for the first row
        Node[] previousRow = new Node[m];
        Node head = null; // this will eventually point to the top-left node of the linked list
        
        for (int i = 0; i < n; i++) {
            Node currentRowHead = null; // keeps track of the head of the current row
            Node previous = null; // keeps track of the previous node in the row

            for (int j = 0; j < m; j++) {
                // Create a new node for arr[i][j]
                Node currentNode = new Node(arr[i][j]);
                
                // Set head if this is the first node in the matrix
                if (i == 0 && j == 0) {
                    head = currentNode;
                }

                // Connect the current node to the previous node in the row (to the left)
                if (previous != null) {
                    previous.right = currentNode;
                }
                previous = currentNode;
                
                // Set the currentRowHead for the first node in the row
                if (j == 0) {
                    currentRowHead = currentNode;
                }

                // Connect the current node to the node above it in the same column (if exists)
                if (i > 0) {
                    previousRow[j].down = currentNode;
                }

                // Store the current node in previousRow to connect downwards in the next iteration
                previousRow[j] = currentNode;
            }
        }

        return head;
    }
}
