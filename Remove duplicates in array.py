'''
Remove duplicates in array
Difficulty: EasyAccuracy: 35.86%Submissions: 56K+Points: 2
Given an array arr consisting of positive integer numbers, remove all duplicate numbers.

Example:

Input: arr[] = [2, 2, 3, 3, 7, 5] 
Output: [2, 3, 7, 5]
Explanation: After removing the duplicates 2 and 3 we get 2 3 7 5.
Input: arr[] = [2, 2, 5, 5, 7, 7] 
Output: [2, 5, 7]
Input: arr[] = [8, 7] 
Output: [8, 7]
Constraints:
1<= arr.size() <=106
2<= arr[i] <=100
'''
class Solution:
    def removeDuplicates(self, arr):
        # code here 
        seen = set()         # Set to store unique elements
        result = []          # List to store result with unique elements in order
    
        for num in arr:
            if num not in seen:
                seen.add(num)  # Add number to seen set
                result.append(num)  # Append to result list if not seen before
    
        return result
