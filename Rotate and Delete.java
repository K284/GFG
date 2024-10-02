/*
Rotate and delete
Difficulty: MediumAccuracy: 20.63%Submissions: 41K+Points: 4
Given an array arr integers. Assume sz to be the initial size of the array. Do the following operations exactly sz/2 times. In every kth (1<= k <= sz/2 ) operation:

Right-rotate the array clockwise by 1.
Delete the (n– k + 1)th element from begin.
Now, Return the first element of the array.
Note: Here n keeps on decreasing with every operation.

Examples:

Input: arr = [1, 2, 3, 4, 5, 6]
Output: 3
Explanation: Rotate the array clockwise i.e. after rotation the array A = {6, 1, 2, 3, 4, 5} and delete the last element that is {5} that will be A = {6, 1, 2, 3, 4}. Again rotate the array for the second time and deletes the second last element that is {2} that will be A = {4, 6, 1, 3}, doing similar operation when we perform 4th operation, 4th last element does not exist. Then we deletes 1st element ie {1} that will be A = {3, 6}. So, continuing this procedure the last element in A is {3}. So, the output will be 3.
Input: arr = [1, 2, 3, 4]
Output: 2
Explanation: Rotate the vector clockwise i.e. after rotation the vector arr = [4, 1, 2, 3] and delete the last element that is 3 that will be arr = [4, 1, 2]. After doing all the operations, the output will be 2.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size() <= 103
1 <= arr[i] <= 106
*/

class Solution {
    public static int rotateDelete(ArrayList<Integer> li) {
        // code here
        int k=1;
        while(li.size()>1){
            int last=li.get(li.size()-1);
            for(int i=li.size()-1;i>0;i--){
                li.set(i,li.get(i-1));
            }
            li.set(0,last);
           
            if(k<=li.size()){
            li.remove(li.size()-k);
            }
            else{
                li.remove(0);
            }
            k++;
        }
        //System.out.println(li);
        return li.get(0);
    }
}
