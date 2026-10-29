class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxWater = 0;

        while(l < r) {
            if(heights[l] <= heights[r]) {
                int currWater = heights[l] * (r - l);
                if (currWater > maxWater) {
                    maxWater = currWater;
                }
                l++;
            }

            if(heights[r] <= heights[l]) {
                int currWater = heights[r] * (r - l);
                if (currWater > maxWater) {
                    maxWater = currWater;
                }
                r--;
            }
        }

        return maxWater;
    }
}
