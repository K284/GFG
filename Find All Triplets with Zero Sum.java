/*
Find All Triplets with Zero Sum
Difficulty: MediumAccuracy: 50.36%Submissions: 41K+Points: 4
Given an array arr[], find all possible triplets i, j, k in the arr[] whose sum of elements is equals to zero. 
Returned triplet should also be internally sorted i.e. i<j<k.

Examples:

Input: arr[] = [0, -1, 2, -3, 1]
Output: [[0, 1, 4], [2, 3, 4]]
Explanation: Triplets with sum 0 are:
arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0
Input: arr[] = [1, -2, 1, 0, 5]
Output: [[0, 1, 2]]
Explanation: Only triplet which satisfies the condition is arr[0] + arr[1] + arr[2] = 1 + (-2) + 1 = 0
Input: arr[] = [2, 3, 1, 0, 5]
Output: [[]]
Explanation: There is no triplet with sum 0.
Constraints:
3 <= arr.size() <= 103
-104 <= arr[i] <= 104
*/
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        List<List<Integer>> res = new ArrayList<>();
int n = arr.length;

// Generating all triplets
for (int i = 0; i < n - 2; i++) {
    for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          
            // If the sum of triplet equals to zero
            // then add its indexes to the result
            if (arr[i] + arr[j] + arr[k] == 0) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(i);
                triplet.add(j);
                triplet.add(k);
                res.add(triplet);
            }
        }
    }
}
return res;

    }
}
