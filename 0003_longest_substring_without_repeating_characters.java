/*
 * NOTES
 * Most important parts are remembering the last repeated index and checking the current size of the substring
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

/*
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestSize = 0;
        int lastIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) {
                if (lastIndex < (map.get(currentChar) + 1)) {
                    lastIndex = map.get(currentChar) + 1;
                }
            }
            if (longestSize < i - lastIndex + 1) {
                longestSize = i - lastIndex + 1;
            }
            map.put(s.charAt(i), i);
        }
        return longestSize;
    }
}