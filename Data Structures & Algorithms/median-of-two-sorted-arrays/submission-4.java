class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums1S = nums1.length < nums2.length ? nums1 : nums2;
        int[] nums2S = nums1.length < nums2.length ? nums2 : nums1;

        int totalLength = nums1S.length + nums2S.length;
        int il = 0;
        int ir = nums1S.length;
        int m = (totalLength + 1) / 2;
        int i = middle(il, ir);
        int j = m - i;

        while(left(nums1S, i) > right(nums2S, j) || left(nums2S, j) > right(nums1S, i)) {
            if (left(nums1S, i) > right(nums2S, j)) {
                ir = i - 1;
            } else {
                il = i + 1;
            }
            i = middle(il, ir);
            j = m - i;
        }

        if (totalLength % 2 != 0) {
            return Math.max(left(nums1S, i), left(nums2S, j));
        } else {
            return (
                Math.max(left(nums1S, i), left(nums2S, j)) + 
                Math.min(right(nums1S, i), right(nums2S, j))
            ) / 2.0;
        }
    }

    private int left(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            return Integer.MIN_VALUE;
        }
        return nums[k - 1];
    }

    private int right(int[] nums, int k) {
        if (k < 0 || k >= nums.length) {
            return Integer.MAX_VALUE;
        }
        return nums[k];
    }

    private int middle(int l, int r) {
        return (r - l) / 2 + l;
    }
}
