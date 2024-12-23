/*
Search in a row-wise sorted matrix
Difficulty: EasyAccuracy: 51.77%Submissions: 19K+Points: 2
Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].

Examples :

Input: mat[][] = [[3, 4, 9],[2, 5, 6],[9, 25, 27]], x = 9
Output: true
Explanation: 9 is present in the matrix, so the output is true.
Input: mat[][] = [[19, 22, 27, 38, 55, 67]], x = 56
Output: false
Explanation: 56 is not present in the matrix, so the output is false.
Input: mat[][] = [[1, 2, 9],[65, 69, 75]], x = 91
Output: false
Explanation: 91 is not present in the matrix.
Constraints:
1 <= n, m <= 1000
1 <= mat[i][j] <= 105
1 <= x <= 105
*/
class Solution {
    // Function to search a given number in a row-wise sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        int n = mat.length;    // Number of rows
        int m = mat[0].length; // Number of columns

        for (int i = 0; i < n; i++) {
            // Perform binary search in the current row
            if (binarySearch(mat[i], x)) {
                return true; // If found in the row, return true
            }
        }

        return false; // If not found in any row, return false
    }

    // Helper function to perform binary search on a row
    private boolean binarySearch(int[] row, int x) {
        int left = 0, right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (row[mid] == x) {
                return true; // Element found
            } else if (row[mid] < x) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return false; // Element not found in the row
    }
}
