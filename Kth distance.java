/*
Kth distance
Difficulty: EasyAccuracy: 48.69%Submissions: 34K+Points: 2
Given an unsorted array arr and a number k which is smaller than the size of the array. Return true if the array contains any duplicate within k distance throughout the array else false.

Examples:

Input: arr[] = [1, 2, 3, 4, 1, 2, 3, 4] and k = 3
Output: false
Explanation: All duplicates are more than k distance away.
Input: arr[] = [1, 2, 3, 1, 4, 5] and k = 3
Output: true
Explanation: 1 is repeated at distance 3.
Input: arr[] = [6, 8, 4, 1, 8, 5, 7] and k = 3
Output: true
Explanation: 8 is repeated at distance 3.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ k < arr.size()
1 ≤ arr[i] ≤ 105
*/
class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            // If the set contains arr[i], a duplicate is found within k distance
            if (set.contains(arr[i])) return true;
            
            // Add the current element to the set
            set.add(arr[i]);

            // Ensure the window size does not exceed k
            if (i >= k) set.remove(arr[i - k]);
        }

        return false; 
    }
}
