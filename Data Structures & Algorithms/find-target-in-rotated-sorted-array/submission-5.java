class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] == target) {
                return m;
            }
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && nums[m] > target) {
                    r = m -1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[r] >= target && nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m -1;
                }
            } 
        }

        return -1;
    }
}
