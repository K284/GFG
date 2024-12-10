/*
Non-overlapping Intervals
Difficulty: MediumAccuracy: 51.92%Submissions: 25K+Points: 4
Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Examples:

Input: intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
Output: 1
Explanation: [1, 3] can be removed and the rest of the intervals are non-overlapping.
Input: intervals[][] = [[1, 3], [1, 3], [1, 3]]
Output: 2
Explanation: You need to remove two [1, 3] to make the rest of the intervals non-overlapping.
Input: intervals[][] = [[1, 2], [5, 10], [18, 35], [40, 45]]
Output: 0
Explanation: All ranges are already non overlapping.
Constraints:
1 ≤ intervals.size() ≤  105
|intervalsi| == 2
0 ≤ starti < endi <=5*104
*/
class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;  // Count of intervals to be removed
        int lastEnd = Integer.MIN_VALUE;  // End time of the last non-overlapping interval
        
        for (int[] interval : intervals) {
            // If there's an overlap
            if (interval[0] < lastEnd) {
                count++;  // Increment removal count
            } else {
                // Update the end time of the last selected interval
                lastEnd = interval[1];
            }
        }
        
        return count;
    }
}
