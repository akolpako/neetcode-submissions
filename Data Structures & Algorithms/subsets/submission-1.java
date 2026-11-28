class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backTrack(int[] nums, int i, List<Integer> path, List<List<Integer>> all) {
        all.add(new ArrayList<>(path));

        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            backTrack(nums, j + 1, path, all);
            path.removeLast();
        }
    }
}
