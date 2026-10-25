class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> allNums = new HashSet<>();
        for (int n = 0; n < nums.length; n++) {
            allNums.add(nums[n]);
        }

        int longestSeqLength = 1; 
        for (Integer num : allNums) {
            
            if (allNums.contains(num - 1)) {
                continue;
            }

            int seqLength = 1;
            int j = 1;

            while(allNums.contains(num + j)) {
                seqLength++;
                j++;
            }

            longestSeqLength = Math.max(longestSeqLength, seqLength);

        }

        return longestSeqLength;
    }
}
