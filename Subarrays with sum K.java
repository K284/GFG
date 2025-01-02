/*
Subarrays with sum K
Difficulty: MediumAccuracy: 49.74%Submissions: 50K+Points: 4
Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.

Examples:

Input: arr = [10, 2, -2, -20, 10], k = -10
Output: 3
Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
Input: arr = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.
Input: arr = [1, 3, 5], k = 0
Output: 0
Explaination: No subarray with 0 sum.
Constraints:

1 ≤ arr.size() ≤ 105
-103 ≤ arr[i] ≤ 103
-107 ≤ k ≤ 107
*/
// User function Template for Java
class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> prefixsumfreq = new HashMap<>();
        int prefixsum=0,count=0;
        prefixsumfreq.put(0,1);
        
        
        for(int num:arr){
            prefixsum+=num;
            
            if (prefixsumfreq.containsKey(prefixsum-k)){
                count+=prefixsumfreq.get(prefixsum-k);
            }
            prefixsumfreq.put(prefixsum, prefixsumfreq.getOrDefault(prefixsum,0)+1);
        }
        return count;
        
    }
}
