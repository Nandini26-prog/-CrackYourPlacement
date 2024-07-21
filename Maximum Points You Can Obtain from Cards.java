There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

 

Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
Example 2:

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.
Example 3:

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 

Constraints:

1 <= cardPoints.length <= 105
1 <= cardPoints[i] <= 104
1 <= k <= cardPoints.length



class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int total = 0;

        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        int maxScore = total;

        // Replace cards from the start with cards from the end one by one.
        for (int i = 0; i < k; i++) {
            total += cardPoints[n - 1 - i] - cardPoints[k - 1 - i];
            maxScore = Math.max(maxScore, total);
        }

        return maxScore;
    }
}


        // int max=Integer.MIN_VALUE;
        // int sum=0;
        // int count=0;
        // for(int i=0;i<cardPoints.length;i++){
        //     int left=i;
        //     int right=cardPoints.length-1;
        //     while(left<right&&count<k){
        //     if(cardPoints[left]>cardPoints[right]){
        //         sum+=cardPoints[left];
        //         left++;
        //         count++;
        //     }
        //     else{
        //         sum+=cardPoints[right];
        //         right--;
        //         count++;
        //     }
        //     }
        // }
        // return sum;
//     }
// }
