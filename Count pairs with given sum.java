/*
Count pairs with given sum
Difficulty: EasyAccuracy: 50.96%Submissions: 8K+Points: 2
Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.

Examples:

Input: arr[] = [1, 5, 7, -1, 5], target = 6 
Output: 3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5). 
Input: arr[] = [1, 1, 1, 1], target = 2 
Output: 6
Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).
Input: arr[] = [10, 12, 10, 15, -1], target = 125
Output: 0
Constraints:
1 <= arr.size() <= 105
-104 <= arr[i] <= 104
1 <= target <= 104
*/
import java.util.HashMap;

class Solution {

    int countPairs(int arr[], int target) {
        // HashMap to store frequency of elements
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        // Traverse the array
        for (int num : arr) {
            // Calculate complement
            int complement = target - num;

            // Check if complement exists in the map
            if (freqMap.containsKey(complement)) {
                count += freqMap.get(complement);
            }

            // Update the frequency of the current element
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
