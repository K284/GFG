/*
Majority Vote
Difficulty: MediumAccuracy: 48.1%Submissions: 39K+Points: 4
You are given an array of integer nums[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return -1. 

Note: The answer should be returned in an increasing format.

Examples:

Input: nums = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
Output: [5, 6]
Explanation: 5 and 6 occur more n/3 times.
Input: nums = [1, 2, 3, 4, 5]
Output: [-1]
Explanation: no candidate occur more than n/3 times.
Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraint:
1 <= nums.size() <= 106
0 <= nums[i] <= 109
*/


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
       int ele1=0,ele2=0,count1=0,count2=0;
       for(int n:nums){
           if(n==ele1){
               count1++;
           }
           else if(n==ele2){
               count2++;
           }else if(count1==0){
               ele1=n;
               count1=1;
           }else if(count2==0){
               ele2=n;
               count2=1;
           }else{
               count1--;
               count2--;
           }
       }
       int one=0,two=0;
       for(int i:nums){
           if(i==ele1){
               one++;
           }
           if(i==ele2){
               two++;
           }
       }
       int temp=nums.size()/3;
       List<Integer> res=new ArrayList<>();
       if(one>temp){
           res.add(ele1);
       }
       if(two>temp){
           res.add(ele2);
       }
       if(res.isEmpty()){
           res.add(-1);
       }
       return res;
        
        
    }
}
