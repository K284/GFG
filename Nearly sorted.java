/*
Nearly sorted
Difficulty: MediumAccuracy: 75.25%Submissions: 63K+Points: 4
Given an array arr[], where each element is at most k away from its target position, you need to sort the array optimally.
Note: You need to change the given array arr[] in place.

Examples:

Input: arr[] = [6, 5, 3, 2, 8, 10, 9], k = 3
Output: [2, 3, 5, 6, 8, 9, 10]
Explanation: The sorted array will be 2 3 5 6 8 9 10
Input: arr[]= [1, 4, 5, 2, 3, 6, 7, 8, 9, 10], k = 2
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: The sorted array will be 1 2 3 4 5 6 7 8 9 10
DO NOT use the direct library sort() function for this question.

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ k < arr.size()
1 ≤ arri ≤ 106
*/
class Solution {
    // Non-static method, so you need to call it on an instance of the class
    public void nearlySorted(int[] arr, int k) {
        // code
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Build the initial heap with the first k+1 elements
        for (int i = 0; i <= k && i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        
        // Now, go through the rest of the array
        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            // Place the smallest element in its correct position
            arr[index++] = minHeap.poll();
            // Add the next element to the heap
            minHeap.add(arr[i]);
        }
        
        // Finally, pop all remaining elements from the heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}
