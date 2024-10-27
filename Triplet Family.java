/*
Triplet Family
Difficulty: BasicAccuracy: 50.0%Submissions: 37K+Points: 1
Given an array arr of integers. Find whether three numbers are such that the sum of two elements equals the third element.

Example:

Input: arr[] = [1, 2, 3, 4, 5]
Output: true
Explanation: The pair (1, 2) sums to 3.
Input: arr[] = [5, 3, 4]
Output: false
Explanation: No triplets satisfy the condition.
Expected Time Complexity: O(n2)
Expected Auxilary Space: O(1)

Constraints:
1 <= arr.size() <= 103
0 <= arr[i] <= 105
*/
int n = arr.length;

        // Sort the array to use the two-pointer technique
        Arrays.sort(arr);

        // Iterate from the end of the array to find the third element of the triplet
        for (int k = 2; k < n; k++) {
            int c = arr[k];
            int i = 0;
            int j = k - 1;

            // Two-pointer approach to find if arr[i] + arr[j] == c
            while (i < j) {
                int sum = arr[i] + arr[j];

                if (sum == c) {
                    return true;
                } else if (sum < c) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        // No triplet found
        return false;
