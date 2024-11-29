/*
Add Binary Strings
Difficulty: MediumAccuracy: 23.25%Submissions: 72K+Points: 4
Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

Input: s1 = "1101", s2 = "111"
Output: 10100
Explanation:
 1101
+ 111
10100
Input: s1 = "00100", s2 = "010"
Output: 110
Explanation: 
  100
+  10
  110
Constraints:
1 ≤s1.size(), s2.size()≤ 106
*/
class Solution {
    public String addBinary(String s1, String s2) {
        int i = s1.length() - 1; // Pointer for the first binary string
        int j = s2.length() - 1; // Pointer for the second binary string
        int carry = 0; // Carry for the binary addition
        StringBuilder result = new StringBuilder(); // To store the resultant binary string
        
        // Traverse both strings from right to left
        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = (i >= 0) ? s1.charAt(i) - '0' : 0; // Get bit from s1 or 0 if out of bounds
            int bit2 = (j >= 0) ? s2.charAt(j) - '0' : 0; // Get bit from s2 or 0 if out of bounds
            
            // Calculate sum of bits and carry
            int sum = bit1 + bit2 + carry;
            result.append(sum % 2); // Append the resulting bit to the result
            carry = sum / 2; // Update the carry
            
            i--; // Move to the next bit in s1
            j--; // Move to the next bit in s2
        }
        
        // Reverse the result and return as a string
        return result.reverse().toString();
    }
}
