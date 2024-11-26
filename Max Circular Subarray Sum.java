/*
Max Circular Subarray Sum
Difficulty: HardAccuracy: 29.37%Submissions: 125K+Points: 8
Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.

Examples:

Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
Output: 22
Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
Output: 23
Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
Input: arr[] = [-1, 40, -14, 7, 6, 5, -4, -1] 
Output: 52
Explanation: Circular Subarray [7, 6, 5, -4, -1, -1, 40] has the maximum sum, which is 52.
Constraints:
1 <= arr.size() <= 105
-104 <= arr[i] <= 104
*/
class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
        int n = arr.length;
        
        // Case 1: Maximum subarray sum using Kadane's algorithm
        int maxNormal = kadane(arr);
        
        // If all elements are negative, return maxNormal
        if (maxNormal < 0) {
            return maxNormal;
        }
        
        // Case 2: Maximum circular subarray sum
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i]; // Invert the array elements
        }
        
        // Kadane on inverted array to find the minimum subarray sum
        int maxCircular = totalSum + kadane(arr);
        
        // Return the maximum of the two cases
        return Math.max(maxNormal, maxCircular);
    }
    
    // Helper function to implement Kadane's algorithm
    private int kadane(int arr[]) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for (int num : arr) {
            maxEndingHere += num;
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
