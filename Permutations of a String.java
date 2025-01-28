/*
Permutations of a String
Difficulty: MediumAccuracy: 34.65%Submissions: 293K+Points: 4
Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

Examples:

Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: Given string ABC has 6 unique permutations.
Input: s = "ABSG"
Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
Explanation: Given string ABSG has 24 unique permutations.
Input: s = "AAA"
Output: ["AAA"]
Explanation: No other unique permutations can be formed as all the characters are same.
Constraints:
1 <= s.size() <= 9
s contains only Uppercase english alphabets
*/
class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        ArrayList<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        
        Arrays.sort(chars);
        backtrack(chars,used, new StringBuilder(), result);
        return result;
    }
    
    public void backtrack(char[] chars, boolean[] used, StringBuilder current, ArrayList<String> result){
        if(current.length()==chars.length){
            result.add(current.toString());
            return;
        }
        for(int i=0; i<chars.length;i++){
            if(used[i] || (i>0 && chars[i]==chars[i-1] && !used[i-1]))
                continue;
            
            used[i]=true;
            current.append(chars[i]);
            
            backtrack(chars,used,current,result);
            
            current.deleteCharAt(current.length()-1);
            used[i] = false;
        }
        
    }
}
