class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Map<Integer, Boolean> seenNums = new HashMap<>();
        for (int n = 0; n < nums.length; n++) {
            seenNums.put(nums[n], false);
        }

        int longestSeqLength = 1; 
        for (int i = 0; i < nums.length; i++) {
            int seqStart = nums[i];

            if (seenNums.get(seqStart)) {
                continue;
            }

            int seqLength = 1;
            int j = 1;
            seenNums.put(seqStart, true);

            while(seenNums.containsKey(seqStart + j)) {
                seenNums.put(seqStart + j, true);
                seqLength++;
                j++;
            }

            longestSeqLength = Math.max(longestSeqLength, seqLength);

        }

        return longestSeqLength;
    }
}
