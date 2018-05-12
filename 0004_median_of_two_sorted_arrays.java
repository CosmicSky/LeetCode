/*
 * NOTES
 * Remember to check for empty array arguments
 * Also remember that arrays maybe have varying sizes so make sure loop
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Index = 0;
        int nums2Index = 0;
        int totalLength = nums1.length + nums2.length;
        int[] total = new int[totalLength];
        int totalIndex = 0;

        if (nums1.length == 0) {
            total = nums2;
        } else if (nums2.length == 0) {
            total = nums1;
        } else {
            while (nums1Index < nums1.length && nums2Index < nums2.length) {
                if (nums1[nums1Index] > nums2[nums2Index]) {
                    total[totalIndex] = nums2[nums2Index];
                    totalIndex++;
                    nums2Index++;
                } else {
                    total[totalIndex] = nums1[nums1Index];
                    totalIndex++;
                    nums1Index++;
                }
            } while (nums1Index < nums1.length || nums2Index < nums2.length) {
                if (nums1Index < nums1.length) {
                    total[totalIndex] = nums1[nums1Index];
                    totalIndex++;
                    nums1Index++;
                } else if (nums2Index < nums2.length) {
                    total[totalIndex] = nums2[nums2Index];
                    totalIndex++;
                    nums2Index++;
                }
            }
        }

        if (totalLength % 2 == 0) {
            double returnedSum = (total[totalLength / 2 - 1] + total[totalLength / 2]) / 2.0;
            return returnedSum;
        } else {
            double returnedSum = total[totalLength / 2];
            return returnedSum;
        }
    }
}