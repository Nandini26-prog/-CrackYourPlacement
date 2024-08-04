Given two arrays arr1[], arr2[], and an integer k. The task is to check if after permuting both arrays in such a way, we get the sum of their corresponding element greater than or equal to k i.e. arr1i + arr2i >= k for all i (from 0 to n-1). Return true if possible, else false. 

Examples:

Input: k = 10, arr1[] = [2, 1, 3], arr2[] = [7, 8, 9]. 
Output: true
Explanation: Permutation  arr1[] = [1, 2, 3] and arr2[] = [9, 8, 7 ] satisfy the condition arr1[i] + arr2[i] >= k
Input: k = 5, arr1[] = [1, 2, 2, 1], b[] = [3, 3, 3, 4].
Output: false
Explanation: Since any permutation won't give the answer.
Expected Time Complexity: O(n*log(n))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ k ≤ 105
0 ≤ arr1i,  arr2i ≤ 2*105

   public boolean isPossible(int k, int[] arr1, int[] arr2) {
        // Your code goes here.
        
           Arrays.sort(arr1);
        
        // Sort arr2 in ascending order
        Arrays.sort(arr2);
        
        // Create a temporary array to reverse arr2
        int[] reversedArr2 = new int[arr2.length];
        for (int i = 0; i < arr2.length; i++) {
            reversedArr2[i] = arr2[arr2.length - 1 - i];
        }
        
        // Check if the sum of corresponding elements is >= k
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] + reversedArr2[i] < k) {
                return false;
            }
        }
        
        return true;
    }
