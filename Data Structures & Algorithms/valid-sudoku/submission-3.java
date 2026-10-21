class Solution {

    private static final int maxDimension = 9;
    private static final int maxBoxDimension = 3;
    private static final char emptyCell = '.';

    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < maxDimension; row++) {
            for (int column = 0; column < maxDimension; column++) {
                char elementToCheck = board[row][column];
                if (isEmptyCell(elementToCheck)) {
                    continue;
                }
                if (!validRow(elementToCheck, row, column, maxDimension, false, board)) {
                    return false;
                }
                if (!validColumn(elementToCheck, row, column, maxDimension, false, board)) {
                    return false;
                }
                if (!validBox(elementToCheck, row, column, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validRow(char elementToCheck, int row, int column, 
                             int maxColumn, boolean inclusiveCurrCol, char[][] board) {
        int startColumn = inclusiveCurrCol ? column : column + 1;
        for (int i = startColumn; i < maxColumn; i++) {
            if (board[row][i] == elementToCheck) {
                return false;
            }
        }
        return true;
    }

    private boolean validColumn(char elementToCheck, int row, int column, 
                                int maxRow, boolean inclusiveCurrRow, char[][] board) {
        int startRow = inclusiveCurrRow ? row : row + 1;
        for (int i = startRow; i < maxRow; i++) {
            if (board[i][column] == elementToCheck) {
                return false;
            }
        }
        return true;
    }

    private boolean validBox(char elementToCheck, int outerRow, int outerColumn, char[][] board) {
        int minBoxRowIndex = calculateMinBoxIndex(outerRow);
        int minBoxColumnIndex = calculateMinBoxIndex(outerColumn);
        int maxBoxRowIndex = calculateMaxBoxIndex(outerRow);
        int maxBoxColumnIndex = calculateMaxBoxIndex(outerColumn);

        for (int row = minBoxRowIndex; row < maxBoxRowIndex; row++) {
            if (row == outerRow) {
                continue;
            }
            if (!validRow(elementToCheck, row, outerColumn, maxBoxColumnIndex, true, board)) {
                return false;
            }
        }

        for (int column = minBoxColumnIndex; column < maxBoxColumnIndex; column++) {
            if (column == outerColumn) {
                continue;
            }
            if (!validColumn(elementToCheck, outerRow, column, maxBoxRowIndex, true, board)) {
                return false;
            }
        }

        return true;
    }

    private int calculateMinBoxIndex(int i) {
        return (i / maxBoxDimension) * maxBoxDimension;
    }

    private int calculateMaxBoxIndex(int i) {
        return calculateMinBoxIndex(i) + maxBoxDimension;
    }

    private boolean isEmptyCell(char elementToCheck) {
        return elementToCheck == emptyCell;
    }
}
