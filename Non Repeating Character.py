'''
Non Repeating Character
Difficulty: EasyAccuracy: 40.43%Submissions: 245K+Points: 2
Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s. If there is no non-repeating character, return '$'.
Note: When you return '$' driver code will output -1.

Examples:

Input: s = "geeksforgeeks"
Output: 'f'
Explanation: In the given string, 'f' is the first character in the string which does not repeat.
Input: s = "racecar"
Output: 'e'
Explanation: In the given string, 'e' is the only character in the string which does not repeat.
Input: s = "aabbccc"
Output: -1
Explanation: All the characters in the given string are repeating.
Constraints:
1 <= s.size() <= 105
'''
class Solution:
    # Function to find the first non-repeating character in a string.
    def nonRepeatingChar(self, s):
        # Step 1: Create a frequency dictionary
        freq = {}
        
        # Step 2: Count the frequency of each character
        for char in s:
            freq[char] = freq.get(char, 0) + 1
        
        # Step 3: Iterate through the string to find the first non-repeating character
        for char in s:
            if freq[char] == 1:
                return char
        
        # If no non-repeating character exists, return '$'
        return '$'
