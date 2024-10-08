Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return ans;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

          
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}



// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         int row=matrix.length-1;
//         int col=matrix[0].length-1;
//         int m=0;
//         List<Integer> ans= new ArrayList<>();

//         while(m<=row){
//         for(int i=m;i<=col;i++){
//            ans.add(matrix[m][i]);
          
//         }
//         for(int i=m+1;i<=row;i++){
//             ans.add(matrix[i][row-m]);
//         }
//         for(int i=col-m-1;i>=m;i--){
//             ans.add(matrix[row-m][i]);
//         }
//         for(int i=m;i<row-m-1;i++){
//             ans.add(matrix[col-m-1][i]);
//         }
//         m++;
//     }
//     return ans;
//     }
// }
