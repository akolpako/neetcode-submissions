class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;

        while (i < nums.length - 2 && nums[i] <= 0) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum < 0) {
                    do l++; while (l < r && nums[l] == nums[l - 1]);
                } else if (sum > 0) {
                    do r--; while (l < r && nums[r] == nums[r + 1]);
                } else {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    do l++; while (l < r && nums[l] == nums[l - 1]);
                    do r--; while (l < r && nums[r] == nums[r + 1]);
                }
            }

            do i++; while (i < nums.length - 2 && nums[i] == nums[i - 1] && nums[i] <= 0);
        }

        return result;
    }
}
