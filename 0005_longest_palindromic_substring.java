/*
 * NOTES
 * check palindrone for both odd and even palindrone lengths
 * s.substring uses starting and ending index
 * make sure to count the index positions for start, end, ect.
 * use helper function to make things easier
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */

/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */

class Solution {
    public String longestPalindrome(String s) {
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int leftIndex = i - 1;
            int rightIndex = i + 1;
            while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)){
                leftIndex--;
                rightIndex++;
            }
            int oddLength = rightIndex - leftIndex - 1;

            leftIndex = i;
            rightIndex = i + 1;
            while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)){
                leftIndex--;
                rightIndex++;
            }
            int evenLength = rightIndex - leftIndex - 1;

            int tempLength = 0;
            if (oddLength > evenLength) {
                tempLength = oddLength;
            } else {
                tempLength = evenLength;
            }

            if (tempLength > endIndex - startIndex) {
                startIndex = i - (tempLength - 1) / 2;
                endIndex = i + tempLength / 2 + 1;
            }
        }
        return s.substring(startIndex, endIndex);
    }
}

/*
public String longestPalindrome(String s) {
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}
*/