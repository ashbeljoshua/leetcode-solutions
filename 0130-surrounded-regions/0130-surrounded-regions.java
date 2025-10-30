class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if (m == 0 || n == 0) return;

        // 1. DFS from all border 'O's and mark them as '#'
        //    Left and right columns
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, m, n);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1, m, n);
            }
        }

        //    Top and bottom rows
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j, m, n);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j, m, n);
            }
        }

        // 2. Flip remaining 'O' -> 'X' (captured), and '#' -> 'O' (safe)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';   // surrounded -> capture it
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';   // border-connected -> restore
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int m, int n) {
        // boundary / stop
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (board[i][j] != 'O') return; // only flood 'O' regions

        // mark this cell as safe
        board[i][j] = '#';

        // 4-directional expansion
        dfs(board, i + 1, j, m, n);
        dfs(board, i - 1, j, m, n);
        dfs(board, i, j + 1, m, n);
        dfs(board, i, j - 1, m, n);
    }
}
    