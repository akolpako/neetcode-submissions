class Solution {
    public int[] productExceptSelf(int[] nums) {
        int productOfAll = 1;
        int zeroesCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroesCounter++;
                if (zeroesCounter > 1) {
                    break;
                }
                continue;
            }
            productOfAll *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = calculateProductExceptCurrent(
                nums[i], productOfAll, zeroesCounter
            );
        }
        return nums;
    }

    private int calculateProductExceptCurrent(int current, int productOfAll, int zeroesCounter) {
        if (zeroesCounter > 1) {
            return 0;
        } else if (zeroesCounter == 1) {
            if (current == 0) {
                return productOfAll;
            }
            return 0;
        } else {
            return productOfAll / current;
        }
    }
}  
