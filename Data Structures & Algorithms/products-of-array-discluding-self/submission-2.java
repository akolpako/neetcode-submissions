class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int productLeft = nums[0];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = productLeft;
            productLeft *= nums[i];
        }

        int productRight = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            result[j] = result[j] * productRight;
            productRight *= nums[j];
        }

        return result;
    }
}  
