/*
Merge Without Extra Space
Difficulty: HardAccuracy: 32.01%Submissions: 271K+Points: 8
Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.

Examples:

Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output:
2 2 3 4
7 10
Explanation: After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10
Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
Output:
1 2 3 5 8 9
10 13 15 20
Explanation: After merging two sorted arrays we get 5 10 12 18 20.
Input: a[] = [0, 1], b[] = [2, 3]
Output:
0 1
2 3
Explanation: After merging two sorted arrays we get 0 1 2 3.
Constraints:
1 <= a.size(), b.size() <= 105
0 <= a[i], b[i] <= 107
*/
class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length, m = b.length;
        int gap = (n + m + 1) / 2; // Initial gap
        
        while (gap > 0) {
            int i = 0, j = gap;

            // Compare elements in the first array.
            while (j < n) {
                if (a[i] > a[j]) {
                    // Swap elements
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                i++;
                j++;
            }

            // Compare elements between the first and second array.
            j = j - n; // Reset j to index in b[] if it exceeds n
            while (i < n && j < m) {
                if (a[i] > b[j]) {
                    // Swap elements
                    int temp = a[i];
                    a[i] = b[j];
                    b[j] = temp;
                }
                i++;
                j++;
            }

            // Compare elements in the second array.
            i = 0;
            while (j < m) {
                if (b[i] > b[j]) {
                    // Swap elements
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
                i++;
                j++;
            }

            // Reduce the gap
            if (gap == 1) {
                gap = 0; // Terminate the loop
            } else {
                gap = (gap + 1) / 2; // Reduce gap
            }
        }
    }
}
