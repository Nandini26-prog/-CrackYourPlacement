Given an array nums[], construct a Product Array P (of same size n) such that P[i] is equal to the product of all the elements of nums except nums[i].

 

Examples:

Input:
nums[] = {10, 3, 5, 6, 2}
Output:
180 600 360 300 900
Explanation: 
For i=0, P[i] = 3*5*6*2 = 180.
For i=1, P[i] = 10*5*6*2 = 600.
For i=2, P[i] = 10*3*6*2 = 360.
For i=3, P[i] = 10*3*5*2 = 300.
For i=4, P[i] = 10*3*5*6 = 900.
Input:
n = 2
nums[] = {12,0}
Output:
0 12
 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
 

Constraints:
1 <= nums.size() <= 1000
0 <= nums[i] <= 200
Array may contain duplicates.

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        int n = nums.length;
        long[] result = new long[n];
        
        // Initialize the result array with 1s for multiplication
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }

        long prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        long suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}
