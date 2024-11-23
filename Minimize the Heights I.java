/*
Minimize the Heights I
Difficulty: MediumAccuracy: 26.16%Submissions: 100K+Points: 4
Given a positive integer k and an array arr[] denoting heights of towers, you have to modify the height of each tower either by increasing or decreasing them by k only once.
Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.

Note: A slight modification of the problem can be found here. 

Examples:

Input: k = 2, arr[] = [1, 5, 8, 10]
Output: 5
Explanation: The array can be modified as [3, 3, 6, 8]. The difference between the largest and the smallest is 8 - 3 = 5.
Input: k = 3, arr[] = [3, 9, 12, 16, 20]
Output: 11
Explanation: The array can be modified as [6, 12, 9, 13, 17]. The difference between the largest and the smallest is 17 - 6 = 11. 
Constraints
1 ≤ k ≤ 104
1 ≤ number of towers ≤ 105
0 ≤ arr[i] ≤ 105
*/
import java.util.Arrays;

class Solution {
    public int getMinDiff(int k, int[] arr) {
        int n = arr.length;
        
        // If there's only one tower, the difference is zero.
        if (n == 1) {
            return 0;
        }

        // Sort the array to arrange towers by their heights.
        Arrays.sort(arr);

        // Initial difference between the maximum and minimum heights.
        int diff = arr[n - 1] - arr[0];

        // The smallest possible height after modification can either be:
        // arr[0] + k (incrementing the smallest tower)
        // arr[n-1] - k (decrementing the largest tower)
        // The largest possible height can either be:
        // arr[n-1] + k (incrementing the largest tower)
        // arr[0] - k (decrementing the smallest tower)
        
        // Start with the initial difference
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        // We go through each element and calculate the possible minimum difference.
        for (int i = 1; i < n; i++) {
            // The smallest tower can either be increased by k or the current tower decreased by k
            int minHeight = Math.min(smallest, arr[i] - k);
            int maxHeight = Math.max(largest, arr[i - 1] + k);
            
            // Update the minimum difference
            diff = Math.min(diff, maxHeight - minHeight);
        }

        return diff;
    }
}
