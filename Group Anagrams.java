Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

  class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {́ 
            char[] charArray = s.toCharArray();
            java.util.Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }

            map.get(sortedString).add(s);
        }

       
        return new ArrayList<>(map.values());
    }
}
