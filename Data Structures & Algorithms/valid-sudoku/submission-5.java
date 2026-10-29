class Solution {

    private static final int maxDimension = 9;
    private static final int maxBoxDimension = 3;
    private static final char emptyCell = '.';

    public boolean isValidSudoku(char[][] board) {
        boolean[][] seenRows = new boolean[maxDimension][maxDimension];
        boolean[][] seenCols = new boolean[maxDimension][maxDimension];
        boolean[][] seenBoxes = new boolean[maxDimension][maxDimension];

        for (int row = 0; row < maxDimension; row++) {
            for (int column = 0; column < maxDimension; column++) {
                char elementToCheck = board[row][column];
                if (isEmptyCell(elementToCheck)) {
                    continue;
                }
                int numberToCheck = elementToCheck - '1';

                if (seenRows[row][numberToCheck]) {
                    return false;
                }
                seenRows[row][numberToCheck] = true;
                
                if (seenCols[column][numberToCheck]) {
                    return false;
                }
                seenCols[column][numberToCheck] = true;

                int boxNumber = boxNumber(row, column);
                if (seenBoxes[boxNumber][numberToCheck]) {
                    return false;
                }
                seenBoxes[boxNumber][numberToCheck] = true;
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
