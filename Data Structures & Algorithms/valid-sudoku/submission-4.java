class Solution {

    private static final int maxDimension = 9;
    private static final int maxBoxDimension = 3;
    private static final char emptyCell = '.';

    public boolean isValidSudoku(char[][] board) {
        int[][] seenRows = new int[maxDimension][maxDimension];
        int[][] seenCols = new int[maxDimension][maxDimension];
        int[][] seenBoxes = new int[maxDimension][maxDimension];

        for (int row = 0; row < maxDimension; row++) {
            for (int column = 0; column < maxDimension; column++) {
                char elementToCheck = board[row][column];
                if (isEmptyCell(elementToCheck)) {
                    continue;
                }
                int numberToCheck = elementToCheck - '1';

                if (seenRows[row][numberToCheck] == 1) {
                    return false;
                }
                seenRows[row][numberToCheck] = 1;
                
                if (seenCols[column][numberToCheck] == 1) {
                    return false;
                }
                seenCols[column][numberToCheck] = 1;

                int boxNumber = boxNumber(row, column);
                if (seenBoxes[boxNumber][numberToCheck] == 1) {
                    return false;
                }
                seenBoxes[boxNumber][numberToCheck] = 1;
            }
        }

        return true;
    }

    private int boxNumber(int row, int col) {
        return (row / maxBoxDimension) * maxBoxDimension + col / maxBoxDimension;
    }

    private boolean isEmptyCell(char elementToCheck) {
        return elementToCheck == emptyCell;
    }
}
