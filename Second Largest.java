/*
Second Largest
Difficulty: EasyAccuracy: 26.72%Submissions: 792K+Points: 2
Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

Note: The second largest element should not be equal to the largest element.

Examples:

Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr[] = [10, 5, 10]
Output: 5
Explanation: The largest element of the array is 10 and the second largest element is 5.
Input: arr[] = [10, 10, 10]
Output: -1
Explanation: The largest element of the array is 10 and the second largest element does not exist.
Constraints:
2 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105
*/
class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        // Traverse through the array
        for (int num : arr) {
            // Update first and second largest values
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }

        // If second largest is still Integer.MIN_VALUE, return -1
        return (second == Integer.MIN_VALUE) ? -1 : second;
        
    }
}