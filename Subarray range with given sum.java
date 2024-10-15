/*
Subarray range with given sum
Difficulty: MediumAccuracy: 42.21%Submissions: 49K+Points: 4
Given an unsorted array of integers arr[], and a target tar, determine the number of subarrays whose elements sum up to the target value.

Examples:

Input: arr[] = [10, 2, -2, -20, 10] , tar = -10
Output: 3
Explanation: Subarrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and [-20, 10].
Input: arr[] = [1, 4, 20, 3, 10, 5] , tar = 33
Output: 1
Explanation: Subarray with sum 33 is: [20,3,10].
Expected Time Complexity: O(n)
Expected Auxilary Space: O(n)

Constraints:
1 <= arr.size() <= 106
-105 <= arr[i] <= 105
-105 <= tar <= 105
*/
class Solution {
        // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
        // HashMap to store the frequency of prefix sums
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Initial condition: There's one way to have a sum of 0, by taking no elements
        prefixSumMap.put(0, 1);
        
        int count = 0;
        int prefixSum = 0;
        
        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Calculate the current prefix sum
            prefixSum += arr[i];
            
            // Check if (prefixSum - tar) exists in the map
            if (prefixSumMap.containsKey(prefixSum - tar)) {
                // If it exists, add the number of times this sum has occurred
                count += prefixSumMap.get(prefixSum - tar);
            }
            
            // Update the map with the current prefix sum
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}
