class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            int curr = nums[i];
            int missingPart = target - curr;

            Integer missingPartIndex = seen.get(missingPart);
            
            if (missingPartIndex != null) {
                return new int[] { missingPartIndex, i };
            } else {
                seen.put(curr, i);
            }
        }
        return new int[] { };
    }
}
