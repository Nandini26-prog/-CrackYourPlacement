
Given two strings S and P. Find the smallest window in the string S consisting of all the characters(including duplicates) of the string P.  Return "-1" in case there is no such window present. In case there are multiple such windows of same length, return the one with the least starting index.
Note : All characters are in Lowercase alphabets. 

Example 1:

Input:
S = "timetopractice"
P = "toc"
Output: 
toprac
Explanation: "toprac" is the smallest
substring in which "toc" can be found.
Example 2:

Input:
S = "zoomlazapzo"
P = "oza"
Output: 
apzo
Explanation: "apzo" is the smallest 
substring in which "oza" can be found.
Your Task:
You don't need to read input or print anything. Your task is to complete the function smallestWindow() which takes two string S and P as input paramters and returns the smallest window in string S having all the characters of the string P. In case there are multiple such windows of same length, return the one with the least starting index. 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(n) n = len(p)

 

Constraints: 
1 ≤ |S|, |P| ≤ 105

class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
       if (s == null || p == null || s.length() < p.length()) {
            return "-1";
        }

        // Frequency maps
        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();

        // Populate frequency map for p
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        int required = pCount.size(); // Number of unique characters in p
        int formed = 0; // Number of unique characters in the current window that match the frequency in p
        int l = 0, r = 0; // Left and right pointers
        int minLength = Integer.MAX_VALUE; // Length of the smallest window
        int start = 0; // Start index of the smallest window

        // Sliding window
        while (r < s.length()) {
            char c = s.charAt(r);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);

            if (pCount.containsKey(c) && sCount.get(c).intValue() == pCount.get(c).intValue()) {
                formed++;
            }

            // Contract the window
            while (l <= r && formed == required) {
                c = s.charAt(l);

                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }

                sCount.put(c, sCount.get(c) - 1);
                if (pCount.containsKey(c) && sCount.get(c).intValue() < pCount.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return minLength == Integer.MAX_VALUE ? "-1" : s.substring(start, start + minLength);
    }
}
