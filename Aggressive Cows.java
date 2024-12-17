/*
Aggressive Cows
Difficulty: MediumAccuracy: 59.57%Submissions: 94K+Points: 4
You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Examples :

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.
Input: stalls[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows, in this case, is 4, which also is the largest among all possible ways.
Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
Output: 1
Explanation: Each cow can be placed in any of the stalls, as the no. of stalls are exactly equal to the number of cows.
The minimum distance between cows, in this case, is 1, which also is the largest among all possible ways.
Constraints:
2 <= stalls.size() <= 106
0 <= stalls[i] <= 108
1 <= k <= stalls.size()
*/
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // Step 1: Sort the stalls
        Arrays.sort(stalls);
        
        // Step 2: Initialize binary search space
        int low = 1;  // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0];  // Maximum possible distance
        int result = 0;

        // Step 3: Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Step 4: Check if the distance 'mid' is feasible
            if (isFeasible(stalls, k, mid)) {
                result = mid;  // Update the result
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return result;
    }

    // Function to check if placing 'k' cows with at least 'distance' is feasible
    private static boolean isFeasible(int[] stalls, int k, int distance) {
        int count = 1;  // First cow placed at stalls[0]
        int lastPlaced = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= distance) {
                count++;  // Place the next cow
                lastPlaced = stalls[i];

                if (count >= k) {
                    return true;  // All cows are placed successfully
                }
            }
        }
        return false;  // Not possible to place all cows
    }
}
