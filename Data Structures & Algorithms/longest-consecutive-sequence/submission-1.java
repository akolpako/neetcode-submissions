class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        Arrays.sort(nums);

        int seqLength = 1;
        int longestSeqLength = seqLength;
        int numInSeq = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currNum = nums[i];

            if (numInSeq == currNum) {
                continue;
            }

            if (currNum == numInSeq + 1) {
                seqLength++;
                if (seqLength > longestSeqLength) {
                    longestSeqLength = seqLength;
                }
            } else {
                seqLength = 1;
            }
            numInSeq = currNum;
        }

        return longestSeqLength;
    }
}
