class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> window = new ArrayDeque<>();
        int windowI = 0;
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            while(!window.isEmpty() && window.peekFirst() <= i - k) {
                window.pollFirst();
            }
            
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }
            window.offerLast(i);
            if (i >= k - 1) {
                result[windowI] = nums[window.peekFirst()];
                windowI++;
            }
        }
        return result;
    }
}
