/*
Count Inversions
Difficulty: MediumAccuracy: 16.93%Submissions: 595K+Points: 4
Given an array of integers arr[]. Find the Inversion Count in the array.
Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104
*/
class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Create a temporary array for merging.
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    // Function to use merge sort and count inversions.
    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int invCount = 0;
        if (left < right) {
            // Find the midpoint.
            int mid = (left + right) / 2;

            // Recursively sort and count inversions in the left half.
            invCount += mergeSortAndCount(arr, temp, left, mid);

            // Recursively sort and count inversions in the right half.
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Merge the two halves and count cross inversions.
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    // Function to merge two halves and count cross inversions.
    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;    // Starting index for left subarray.
        int j = mid + 1; // Starting index for right subarray.
        int k = left;    // Starting index to store sorted elements.
        int invCount = 0;

        // Merge the two halves while counting inversions.
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // Count inversions for all remaining elements in the left subarray.
                invCount += (mid - i + 1);
            }
        }

        // Copy remaining elements of left subarray, if any.
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right subarray, if any.
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy sorted elements back to the original array.
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }
}
