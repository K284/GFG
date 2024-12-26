/*
Two Sum - Pair with Given Sum
Difficulty: EasyAccuracy: 30.61%Submissions: 311K+Points: 2
Given an array arr[] of positive integers and another integer target. Determine if there exists two distinct indices such that the sum of there elements is equals to target.

Examples:

Input: arr[] = [1, 4, 45, 6, 10, 8], target = 16
Output: true
Explanation: arr[3] + arr[4] = 6 + 10 = 16.
Input: arr[] = [1, 2, 4, 3, 6], target = 11
Output: false
Explanation: None of the pair makes a sum of 11.
Constraints:
1 ≤ arr.size ≤ 105
1 ≤ arr[i] ≤ 105
1 ≤ target ≤ 2*105
*/
import java.util.HashSet;

class Solution {
    boolean twoSum(int arr[], int target) {
        // Create a HashSet to store elements
        HashSet<Integer> set = new HashSet<>();

        // Traverse the array
        for (int num : arr) {
            // Calculate the complement
            int complement = target - num;

            // Check if complement exists in the set
            if (set.contains(complement)) {
                return true;
            }

            // Add the current number to the set
            set.add(num);
        }

        // If no such pair is found
        return false;
    }
}
