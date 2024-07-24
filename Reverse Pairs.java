Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1


class Solution {

    int count;
    public int reversePairs(int[] nums) {
        //reverse pair means: first element should be larger than twice of second number
        count=0;
        merge(nums,0,nums.length-1);
        return count;

    }

    public int[] merge(int[] nums, int left, int right){
        if(left==right)
            {
                return new int[] {nums[left]};
            }

        int mid=left+(right-left)/2;
        int[] m1= merge(nums,left,mid);
        int[] m2= merge(nums,mid+1,right);

        int j=0;
        for(int i=0;i<m1.length;i++){
            while(j<m2.length && 2*(long)m2[j] < m1[i])
            //note that here: while(j < m2.length && (long)m1[i] > 2*m2[j]) would not work because of different places of long keyword
                j++;
            count+=j;
        }

        int [] merged= new int[right-left+1];
        int p=0;
        int i=0;
        j=0;
        while(i<m1.length||j<m2.length){
            if(i<m1.length && j<m2.length)
                merged[p++]=m1[i]<=m2[j]?m1[i++]:m2[j++];
            else if(i<m1.length)
                merged[p++]=m1[i++];
            else
                merged[p++]=m2[j++];
        }
        return merged;
    }
}
