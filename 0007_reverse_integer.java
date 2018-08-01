/*
 * NOTES
 * https://leetcode.com/problems/reverse-integer/description/
 */

/*
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 *
 * Example 2:
 *
 * Input: -123
 * Output: -321
 *
 * Example 3:
 *
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For
 * the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 */

class Solution {
    public int reverse(int x) {
        int returned = 0;

        while (x != 0) {
            int popped = x % 10;
            x /= 10;
            if (returned > 214748364 || (popped > 7 && returned > 214748363)) {return 0;}
            if (returned < -214748364 || (popped < -8 && returned < -214748363)) {return 0;}
            returned = returned * 10 + popped;
        }
        return returned;
    }
}