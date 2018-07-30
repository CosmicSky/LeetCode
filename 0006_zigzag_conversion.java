/*
 * NOTES
 * String is immutable. Use StringBuilder to build a constantly updating String.
 * Look for patterns by using examples
 * https://leetcode.com/problems/zigzag-conversion/description/
 */

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder returned = new StringBuilder();
        int cycleLength = 2 * numRows - 2;
        int stringLength = s.length();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < stringLength; j += cycleLength) {
                returned.append(s.charAt(i + j));
                if ((i != 0) && (i != numRows - 1) && j + cycleLength - i < stringLength) {
                    returned.append(s.charAt(j + cycleLength - i));
                }
            }
        }
        return returned.toString();
    }
}
