Given an array arr[] of length n. Find all possible unique permutations of the array in sorted order. A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.

Example 1:

Input: 
n = 3
arr[] = {1, 2, 1}
Output: 
1 1 2
1 2 1
2 1 1
Explanation:
These are the only possible unique permutations
for the given array.
Example 2:

Input: 
n = 2
arr[] = {4, 5}
Output: 
Only possible 2 unique permutations are
4 5
5 4
Your Task:
You don't need to read input or print anything. You only need to complete the function uniquePerms() that takes an integer n, and an array arr of size n as input and returns a sorted list of lists containing all unique permutations of the array.

Expected Time Complexity:  O(n*n!)
Expected Auxilliary Space: O(n*n!)

Constraints:
1 ≤ n ≤ 9



class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        Collections.sort(arr);
        backtrack(arr, new boolean[n], new ArrayList<>(), res,n);
        return res;
    }
    
    private static void backtrack(ArrayList<Integer> arr,boolean[] visited, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> res ,int n){
        if(current.size()==n)
            res.add(new ArrayList<>(current));
        else{
            for(int i=0;i<n;i++){
                if(visited[i])
                    continue;
                    
                if(i>0 && arr.get(i)==arr.get(i-1) && !visited[i-1])
                    continue;
                    
                visited[i]=true;
                current.add(arr.get(i));
                backtrack(arr, visited, current, res,n);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
            
        }
    }
};
