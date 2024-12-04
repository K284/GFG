/*
Strings Rotations of Each Other
Difficulty: EasyAccuracy: 43.83%Submissions: 218K+Points: 2
You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

Note: The characters in the strings are in lowercase.

Examples :

Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: After 2 right rotations, s1 will become equal to s2.
Input: s1 = "aab", s2 = "aba"
Output: true
Explanation: After 1 left rotation, s1 will become equal to s2.
Input: s1 = "abcd", s2 = "acbd"
Output: false
Explanation: Strings are not rotations of each other.
Constraints:
1 <= s1.size(), s2.size() <= 105
*/
class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Check if the lengths of the strings are equal
        if (s1.length() != s2.length()) {
            return false;
        }
        // Concatenate s1 with itself
        String concatenated = s1 + s1;
        // Use KMP algorithm to check if s2 is a substring of concatenated string
        return isSubstring(concatenated, s2);
    }

    // Function to check if needle is a substring of haystack using KMP
    private static boolean isSubstring(String haystack, String needle) {
        int[] lps = buildLPS(needle);
        int i = 0, j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return true;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    // Function to build the Longest Prefix Suffix (LPS) array for KMP
    private static int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0, i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length > 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
