class Solution {
    public boolean isValidSudoku(char[][] board) {

        if(board==null || board.length == 0 || board[0].length == 0) return false;

        int m = board.length;
        int n = board[0].length;
        int[][] rows = new int[m][9];
        int[][] columns = new int[n][9];
        int[][] boxs = new int [9] [9];

        for(int i = 0;i<m;i++) {
            for(int j = 0; j<n ; j++) {
                if(board[i][j] != '.'){
                    int val = board[i][j] - '1';

                    if(rows[i][val] ==1) return false;
                    else if(columns[j][val]==1) return false;
                    else if ( boxs[ (i/3)*3+ j/3  ] [val]==1) return false;
                    rows[i][val] = 1;
                    columns[j][val] =1;
                    boxs[ (i/3)*3 + j/3 ][val] = 1;



                }

            }

        }
        return true;


        
    }
}