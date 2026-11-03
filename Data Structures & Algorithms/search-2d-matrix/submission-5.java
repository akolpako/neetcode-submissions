class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] inFirstColumnSearchResult = binarySearch(
            i -> matrix[i][0], matrix.length, target
        );

        if (inFirstColumnSearchResult[1] != -1) {
            return true;
        }

        int row = inFirstColumnSearchResult[0];

        if (row < 0) {
            return false;
        }

        int[] rowSearchResult = binarySearch(
            i -> matrix[row][i], matrix[row].length, target
        );

        return rowSearchResult[1] != -1;
    }

    private int[] binarySearch(Array array, int size, int target) {
        int l = 0, r = size - 1;

        while(l <= r) {
            int m = (r - l) / 2 + l;

            int numInM = array.at(m);
            if (numInM == target) {
                return new int[]{l, m};
            } else if (numInM > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return new int[]{r, -1};
    }

    private interface Array {
        int at(int i);
    }
}
