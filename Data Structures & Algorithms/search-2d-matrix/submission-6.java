class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = floorBinarySearch(
            i -> matrix[i][0], matrix.length, target
        );

        if (row < 0) {
            return false;
        }

        if (matrix[row][0] == target) {
            return true;
        }

        int column = floorBinarySearch(
            i -> matrix[row][i], matrix[row].length, target
        );

        return matrix[row][column] == target;
    }

    private int floorBinarySearch(Array array, int size, int target) {
        int l = 0, r = size - 1;

        while(l <= r) {
            int m = (r - l) / 2 + l;

            int numInM = array.at(m);
            if (numInM == target) {
                return m;
            } else if (numInM > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return r;
    }

    private interface Array {
        int at(int i);
    }
}
