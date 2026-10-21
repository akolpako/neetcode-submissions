class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> existingUnique = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (existingUnique.contains(curr)) {
                return true;
            }
            existingUnique.add(curr);
        }
        return false;
    }
}