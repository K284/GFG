/*
Implement Pow
Difficulty: MediumAccuracy: 52.79%Submissions: 14K+Points: 4
Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).

Examples:

Input: b = 3.00000, e = 5
Output: 243.00000
Input: b = 0.55000, e = 3
Output: 0.16638
Input: b = -0.67000, e = -7
Output: -16.49971
Constraints:

-100.0 < b < 100.0
-109 <= e <= 109
Either b is not zero or e > 0.
-104 <= be <= 104
*/
class Solution {
    double power(double b, int e) {
        // code here
        if(e==0) return 1.0;
        double result = 1.0;
        long exp = Math.abs((long)e);
        
        while(exp>0){
            if((exp & 1)==1) result*=b;
            b*=b;
            exp>>=1;
        }
        return e<0 ? 1.0/result : result;
    }
}
