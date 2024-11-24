/*
Kadane's Algorithm
Difficulty: MediumAccuracy: 36.28%Submissions: 1MPoints: 4
Given an integer array arr[]. You need to find the maximum sum of a subarray.

Examples:

Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
Input: arr[] = [-2, -4]
Output: -2
Explanation: The subarray {-2} has the largest sum -2.
Input: arr[] = [5, 4, 1, 7, 8]
Output: 25
Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.
Constraints:
1 ≤ arr.size() ≤ 105
-109 ≤ arr[i] ≤ 104
*/
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        // Initialize variables to store the maximum sum so far and the current sum.
        int maxSoFar = arr[0]; // Maximum sum found so far
        int maxEndingHere = arr[0]; // Sum of the current subarray ending at this position

        // Traverse the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Update the current subarray sum
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);

            // Update the global maximum sum if the current sum is greater
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar; // Return the maximum sum found
    }
}
