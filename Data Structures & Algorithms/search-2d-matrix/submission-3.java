class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] firstColumn = new int[matrix.length];
        for (int i = 0; i < firstColumn.length; i++) {
            firstColumn[i] = matrix[i][0];
        }

        int[] inFirstColumnSearchResult = binarySearch(firstColumn, target);

        if (inFirstColumnSearchResult[2] != -1) {
            return true;
        }

        int row = inFirstColumnSearchResult[0];

        if (row < 0) {
            return false;
        }

        int[] rowSearchResult = binarySearch(matrix[row], target);

        return rowSearchResult[2] != -1;
    }

    private int[] binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l <= r) {
            int m = (r - l) / 2 + l;

            if (nums[m] == target) {
                return new int[]{l, r, m};
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return new int[]{r, l, -1};
    }
}
