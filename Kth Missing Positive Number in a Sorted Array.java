/*
Kth Missing Positive Number in a Sorted Array
Difficulty: MediumAccuracy: 53.02%Submissions: 22K+Points: 4
Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].  

Examples :

Input: arr[] = [2, 3, 4, 7, 11], k = 5
Output: 9
Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.
Input: arr[] = [1, 2, 3], k = 2
Output: 5
Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.
Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
Output: 2
Explanation: Missing are 1, 2, 4, 6… and 2nd missing number is 2.
Constraints:
1 <= arr.size() <= 105
1 <= k <= 105
1 <= arr[i]<= 106
*/
class Solution {
    public int kthMissing(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;

        // Binary search to find the position where kth missing lies
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Calculate the number of missing elements before arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                // If less than k missing numbers, move to the right
                low = mid + 1;
            } else {
                // Otherwise, move to the left
                high = mid - 1;
            }
        }

        // The kth missing number is in the gap after the `high` index
        return k + high + 1;
    }
}
