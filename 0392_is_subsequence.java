/*
 * NOTES
 * https://leetcode.com/problems/is-subsequence/description/
 */

/*
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s
 * is a short string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: Return true.
 *
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: Return false.
 *
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In
 * this scenario, how would you change your code?
 *
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        if (t.equals(s)){
            return true;
        }

        int currentIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            char t_CurrentChar = t.charAt(i);
            char s_CurrentChar = s.charAt(currentIndex);
            if (t_CurrentChar == s_CurrentChar) {
                currentIndex++;
            }
            if (currentIndex == s.length()) {
                return true;
            }
        }
        return false;
    }
}