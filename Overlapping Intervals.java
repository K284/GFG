/*
Overlapping Intervals
Difficulty: MediumAccuracy: 57.41%Submissions: 85K+Points: 4
Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

Examples:

Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
Output: [[1,4], [6,8], [9,10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].
Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
Output: [[1,9]]
Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ starti ≤ endi ≤ 105
*/
class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // List to hold the result
        List<int[]> result = new ArrayList<>();
        
        // Edge case: if the array is empty, return an empty list
        if (arr.length == 0) return result;

        // Sort the intervals by the start times
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize the first interval
        int[] currentInterval = arr[0];
        result.add(currentInterval);

        // Iterate through the intervals
        for (int i = 1; i < arr.length; i++) {
            int currentEnd = currentInterval[1];
            int nextStart = arr[i][0];
            int nextEnd = arr[i][1];

            // Check if the current interval overlaps with the next
            if (currentEnd >= nextStart) {
                // Merge the intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the next interval to the result
                currentInterval = arr[i];
                result.add(currentInterval);
            }
        }

        return result;
    }
}
