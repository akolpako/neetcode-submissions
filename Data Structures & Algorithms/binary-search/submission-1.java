class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(r - l > 1) {
            int m = middle(l, r);

            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m;
            } else {
                l = m;
            }
        }

        return nums[l] == target ? l : nums[r] == target ? r : -1;
    }

    private int middle(int l, int r) {
        return r != l ? (r - l) / 2 + l : r;
    }
}
