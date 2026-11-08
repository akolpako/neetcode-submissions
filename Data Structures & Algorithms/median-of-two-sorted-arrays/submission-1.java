class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;

        while(i < nums1.length || j < nums2.length) {
            if (j >= nums2.length || (i < nums1.length && nums1[i] <= nums2[j])) {
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }

        int m = (merged.length - 1) / 2;
        if (merged.length % 2 != 0) {
            return merged[m];
        } else {
            return (merged[m] + merged[m+1]) / 2.0;
        }
    }
}
