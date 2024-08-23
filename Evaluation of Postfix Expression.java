Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. Operators will only include the basic arithmetic operators like *, /, + and -.

 

Example 1:

Input: S = "231*+9-"
Output: -4
Explanation:
After solving the given expression, 
we have -4 as result.
Example 2:

Input: S = "123+*8-"
Output: -3
Explanation:
After solving the given postfix 
expression, we have -3 as result.

Your Task:
You do not need to read input or print anything. Complete the function evaluatePostfixExpression() that takes the string S denoting the expression as input parameter and returns the evaluated value.


Expected Time Complexity: O(|S|)
Expected Auixilliary Space: O(|S|)


Constraints:
1 ≤ |S| ≤ 105

0 ≤ |Si|≤ 9 (And given operators)
  class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> s1=new Stack<>();
        
        for(char c:S.toCharArray()){
            if(Character.isDigit(c))
            s1.push(Integer.parseInt(String.valueOf(c)));
            else{
                int op1=s1.pop();
                int op2=s1.pop();
                int ans=operate(op1,op2,c);
                s1.push(ans);
            }
        }
        return s1.pop();
    }
    
    private static int operate(int op2, int op1, char c){
        switch(c){
            case '+': return op1+op2;
             case '-': return (op1-op2);
             case '*': return (op1*op2);
             case '/': return (op1/op2);
             default: return -1;
        }
    }
}
