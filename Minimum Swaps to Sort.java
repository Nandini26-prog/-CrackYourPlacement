Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.


Example 1:

Input:
nums = {2, 8, 5, 4}
Output:
1
Explanation:
swap 8 with 4.
Example 2:

Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explanation:
swap 10 with 3 and swap 19 with 5.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minSwaps() which takes the nums as input parameter and returns an integer denoting the minimum number of swaps required to sort the array.
If the array is already sorted, return 0. 


Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ n ≤ 105
1 ≤ numsi ≤ 106

  class Solution {

    // Function to find the minimum number of swaps required to sort the array
    public  int minSwaps(int[] arr) {
        int n = arr.length;

        // Create an array of pairs where each pair contains an element and its index
        Pair[] arrPos = new Pair[n];
        for (int i = 0; i < n; i++) {
            arrPos[i] = new Pair(arr[i], i);
        }

        // Sort the array by array element values
        Arrays.sort(arrPos, Comparator.comparingInt(o -> o.value));

        // To keep track of visited elements (already swapped)
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        // Initialize the number of swaps
        int swapCount = 0;

        // Traverse array elements
        for (int i = 0; i < n; i++) {
            // If the element is already in the correct position or already visited
            if (visited[i] || arrPos[i].index == i) {
                continue;
            }

            // Calculate the size of the cycle
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arrPos[j].index;
                cycleSize++;
            }

            // Add the cycle size to the number of swaps
            if (cycleSize > 1) {
                swapCount += (cycleSize - 1);
            }
        }

        return swapCount;
    }

    // Helper class to store array elements and their indices
    class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

 
}
