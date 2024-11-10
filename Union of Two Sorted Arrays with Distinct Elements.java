/*
Union of Two Sorted Arrays with Distinct Elements
Difficulty: EasyAccuracy: 55.4%Submissions: 19K+Points: 2
Given two sorted arrays a[] and b[], where each array contains distinct elements , the task is to return the elements in the union of the two arrays in sorted order.

Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.
Examples:

Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
Output: 1 2 3 4 5 6 7
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
Input: a[] = [2, 3, 4, 5], b[] = [1, 2, 3, 4]
Output: 1 2 3 4 5
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.
Input: a[] = [1], b[] = [2]
Output: 1 2
Explanation: Distinct elements including both the arrays are: 1 2.
Constraints:
1  <=  a.size(), b.size()  <=  105
-109  <=  a[i] , b[i]  <=  109

*/
class Solution {
    // Function to return a list containing the union of the two sorted arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (i < a.length && j < b.length) {
            // Skip duplicates in array 'a'
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            // Skip duplicates in array 'b'
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            // Compare elements and add to the result
            if (a[i] < b[j]) {
                result.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                result.add(b[j]);
                j++;
            } else {
                result.add(a[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements from array 'a'
        while (i < a.length) {
            if (i == 0 || a[i] != a[i - 1]) {
                result.add(a[i]);
            }
            i++;
        }

        // Add remaining elements from array 'b'
        while (j < b.length) {
            if (j == 0 || b[j] != b[j - 1]) {
                result.add(b[j]);
            }
            j++;
        }

        return result;
    }
}
