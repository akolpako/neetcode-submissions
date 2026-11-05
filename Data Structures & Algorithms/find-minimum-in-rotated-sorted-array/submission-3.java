class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while(r - l > 1) {
            int m = (r - l) / 2 + l;

            if (nums[m] < nums[l] || nums[l] < nums[r]) {
                r = m;
            } else {
                l = m;
            }
        }

        return Math.min(nums[l], nums[r]);
    }
}
