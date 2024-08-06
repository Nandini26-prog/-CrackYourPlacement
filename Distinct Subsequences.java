Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag
 

Constraints:

1 <= s.length, t.length <= 1000
s and t consist of English letters.
  class Solution {
    public int numDistinct(String s, String t) {
        int [][] mem= new int [t.length()+1][s.length()+1];

        for(int j=0;j<=s.length();j++){
            mem[0][j]=1;
        }
        for(int i=0;i<t.length();i++){
            for(int j=0;j<s.length();j++){
                if(t.charAt(i)==s.charAt(j)){
                    mem[i+1][j+1]=mem[i][j]+mem[i+1][j];
                }
                else{
                    mem[i+1][j+1]=mem[i+1][j];
                }
            }
        }
        return mem[t.length()][s.length()];
    }
}
