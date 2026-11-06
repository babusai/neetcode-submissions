class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> values = new HashMap<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != '.') {
                    if (values.containsKey(board[row][col])) {
                        return false;
                    } else {
                        values.put(board[row][col], 1);
                    }
                }
            }
            values.clear();
        }

        for (int col = 0; col < board[0].length; col++) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != '.') {
                    if (values.containsKey(board[row][col])) {
                        return false;
                    } else {
                        values.put(board[row][col], 1);
                    }
                }
            }
            values.clear();
        }

        for (int rStart = 0; rStart < 9; rStart += 3) {
            for (int cStart = 0; cStart < 9; cStart += 3) {
                for (int row = rStart; row < rStart + 3; row++) {
                    for (int col = cStart; col < cStart + 3; col++) {
                        if (board[row][col] != '.') {
                            if (values.containsKey(board[row][col])) {
                                return false;
                            } else {
                                values.put(board[row][col], 1);
                            }
                        }
                    }
                }
                values.clear();
            }
        }

        return true;
    }
}
