/*
Trapping Rain Water
Difficulty: HardAccuracy: 33.14%Submissions: 445K+Points: 8
Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

Examples:

Input: arr[] = [3, 0, 1, 0, 4, 0 2]
Output: 10
Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.
Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides.
Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
Output: 9
Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.
Constraints:
1 < arr.size() < 105
0 < arr[i] < 103
*/
class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        if (n<3) return 0;
        
        int left=0,right=n-1;
        int leftmax=0,rightmax=0,watertrapped = 0;
        
        while(left<=right){
            if(arr[left]<arr[right]){
                if(arr[left]>leftmax)
                    leftmax=arr[left];
                
                else
                    watertrapped+=leftmax-arr[left];
                
                left++;
            }
            else{
                if(arr[right]>rightmax)
                    rightmax=arr[right];
                    
            else
                watertrapped+=rightmax-arr[right];
            
            right--;
            }
        }
        return watertrapped;
    }
}
