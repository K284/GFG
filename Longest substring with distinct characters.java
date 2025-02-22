/*
Longest substring with distinct characters
Difficulty: EasyAccuracy: 31.32%Submissions: 142K+Points: 2
Given a string s, find the length of the longest substring with all distinct characters. 

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.
Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.
Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.
Constraints:
1<= s.size()<=3*104
All the characters are in lowercase.
*/
class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        HashMap<Character, Integer> charindexmap = new HashMap<>();
        
        int maxlength = 0;
        int start =0;
        
        for(int end=0; end<s.length(); end++){
            char currentchar = s.charAt(end);
            
            if(charindexmap.containsKey(currentchar) && charindexmap.get(currentchar)>=start)
            start = charindexmap.get(currentchar)+1;
            
            charindexmap.put(currentchar,end);
            
            maxlength = Math.max(maxlength,end-start+1);
        }
        return maxlength;
    }
}
