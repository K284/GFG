/*
K-th element of two Arrays
Difficulty: MediumAccuracy: 37.4%Submissions: 298K+Points: 4
Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
Output: 256
Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.
Constraints:

1 <= a.size(), b.size() <= 106
1 <= k <= a.size() + b.size()
0 <= a[i], b[i] < 108
*/
class Solution {
    public int kthElement(int a[], int b[], int k) {
        // Ensure a[] is the smaller array
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }
        
        int n = a.length, m = b.length;
        int low = Math.max(0, k - m), high = Math.min(k, n); // Binary search range

        while (low <= high) {
            int cutA = (low + high) / 2;    // Number of elements taken from a[]
            int cutB = k - cutA;            // Remaining elements taken from b[]

            // Handle edge cases for partitions
            int leftA = (cutA == 0) ? Integer.MIN_VALUE : a[cutA - 1];
            int rightA = (cutA == n) ? Integer.MAX_VALUE : a[cutA];
            int leftB = (cutB == 0) ? Integer.MIN_VALUE : b[cutB - 1];
            int rightB = (cutB == m) ? Integer.MAX_VALUE : b[cutB];

            // Check if partition is valid
            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            }

            // Adjust binary search range
            if (leftA > rightB) {
                high = cutA - 1; // Move left
            } else {
                low = cutA + 1;  // Move right
            }
        }
        
        return -1; // Invalid input case (should not occur)
    }
}

