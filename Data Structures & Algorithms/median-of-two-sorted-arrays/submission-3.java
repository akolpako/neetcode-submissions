class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mergedLength = nums1.length + nums2.length;
        int m = (mergedLength - 1) / 2;
        int mVal = 0;
        int mNextVal = 0;
        int i = 0, j = 0, k = 0;

        while(k <= m + 1) {
            int val = 0;
            if (j >= nums2.length || (i < nums1.length && nums1[i] <= nums2[j])) {
                if (i < nums1.length) {
                    val = nums1[i];
                }
                i++;
            } else {
                if (j < nums2.length) {
                    val = nums2[j];
                }
                j++;
            }
            if (k == m) {
                mVal = val;
            } else if (k == m + 1) {
                mNextVal = val;
            }
            k++;
        }

        if (mergedLength % 2 != 0) {
            return mVal;
        } else {
            return (mVal + mNextVal) / 2.0;
        }
    }
}
