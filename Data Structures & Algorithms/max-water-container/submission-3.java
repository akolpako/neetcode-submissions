class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxWater = 0;

        while(l < r) {
            int currWater = Math.min(heights[l], heights[r]) * (r - l);
            if (currWater > maxWater) {
                maxWater = currWater;
            }
            if(heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxWater;
    }
}
