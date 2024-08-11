Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:

Input: nums = [-1]
Output: [0]
Example 3:

Input: nums = [-1,-1]
Output: [0,0]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

  class Solution {
 public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (n == 0) return ans;

        // Step 1: Coordinate compression
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedNums) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        // Initialize BIT (size n + 1 for 1-based index)
        int[] BIT = new int[n + 1];

        // Step 2: Traverse from right to left in nums array
        for (int i = n - 1; i >= 0; i--) {
            int currentRank = rankMap.get(nums[i]); // Use a different variable name
            ans.add(query(BIT, currentRank - 1));  // Query the BIT for counts of smaller elements
            update(BIT, currentRank, 1);           // Update the BIT with the current element's rank
        }

        // Since we collected results in reverse order, reverse the list
        Collections.reverse(ans);
        return ans;
    }

    // Helper function to update the BIT
    private void update(int[] BIT, int index, int value) {
        while (index < BIT.length) {
            BIT[index] += value;
            index += index & -index;
        }
    }

    // Helper function to query the BIT
    private int query(int[] BIT, int index) {
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & -index;
        }
        return sum;
    }
}
        // HashMap<Integer, Integer> ref= new HashMap<>();
        // int[] temp=new int[nums.length];
        // for(int i=0;i<nums.length;i++)
        //      temp[i]=nums[i];
        //  Arrays.sort(temp);

        // for(int i=temp.length-1;i>=0;i--){
        //     ref.put(temp[i],i);
        // }
        // for(int i=0;i<nums.length;i++){
        //     ans.add(ref.get(nums[i]));
        // }
        //return ans;
    
