Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

 

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
 

Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000
  class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max1,max2;

        max1=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        max2=nums[0]*nums[1]*nums[nums.length-1] ;//because in case of mixed array the largest elements can be found on edges of the array

        return Math.max(max1,max2);
    //   return prod;
    //     int prod=1;
    //     Arrays.sort(nums);
    //     if(nums[nums.length-1]<=0)
    //         prod=prod*nums[0]*nums[1]*nums[2];
    //     else
    //          prod=prod*nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
    //   return prod;
    }
}
