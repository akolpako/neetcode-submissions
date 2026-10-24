class Solution {
    private static final int NOT_FOUND = -1;

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int l = 0;

        while (nums[l] <= 0 && l < nums.length - 1) {
            int r = nums.length - 1;
            while (nums[r] >= 0 && l < r - 1) {
                binarySearchThreeSum(nums, l, r, result);
                r--;
            }
            l++;
        }

        return List.copyOf(result);
    }

    private void binarySearchThreeSum(int[] nums, int l, int r, Set<List<Integer>> result) {
        if (l + 1 == r) {
            return;
        }

        int lNum = nums[l];
        int rNum = nums[r];
        int target = (lNum + rNum) * -1;

        int found = binarySearch(nums, target, l + 1, r - 1);

        if (found != NOT_FOUND) {
            result.add(List.of(lNum, target, rNum));
        }
    }

    public int binarySearch(int[] nums, int target, int l, int r) {
        int found = NOT_FOUND;

        while (l <= r) {
            int m = getMiddle(l, r);
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] == target) {
                found = m;
                break;
            }
        }
        return found;
    }

    private int getMiddle(int l, int r) {
        return l  + ((r - l) / 2);
    }
}
