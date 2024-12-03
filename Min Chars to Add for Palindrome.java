/*
Min Chars to Add for Palindrome
Difficulty: HardAccuracy: 46.79%Submissions: 65K+Points: 8
Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.

Note: A palindrome string is a sequence of characters that reads the same forward and backward.

Examples:

Input: s = "abc"
Output: 2
Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"
Input: s = "aacecaaaa"
Output: 2
Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"
Constraints:
1 <= s.size() <= 106
*/
class Solution {
    public static int minChar(String s) {
        // Reverse the string
        String rev = new StringBuilder(s).reverse().toString();
        
        // Concatenate original and reversed string with a separator
        String temp = s + "#" + rev;
        
        // Compute LPS array
        int[] lps = computeLPS(temp);
        
        // Minimum characters to add
        return s.length() - lps[temp.length() - 1];
    }
    
    private static int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0; // length of previous longest prefix suffix
        int i = 1;
        
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}
