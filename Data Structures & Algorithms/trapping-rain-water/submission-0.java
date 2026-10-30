class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int leftMaxH = height[l];
        int rightMaxH = height[r];
        int water = 0;

        while(l < r) {
            if (leftMaxH <= rightMaxH) {
                l++;
                leftMaxH = Math.max(leftMaxH, height[l]);
                water += leftMaxH - height[l];
            } else {
                r--;
                rightMaxH = Math.max(rightMaxH, height[r]);
                water += rightMaxH - height[r];
            }
        }

        return water;
    }
}
