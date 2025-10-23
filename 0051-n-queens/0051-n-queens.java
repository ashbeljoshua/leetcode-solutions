class Solution {
    public List<List<String>> solveNQueens(int n) {

            List<List<String>> res = new ArrayList<>();
            if(n==0) return res;

            char[][] board = new char[n][n];
            boolean[] cols  = new boolean[n];
            boolean[] diag1 = new boolean[2*n];
            boolean[] diag2 = new boolean[2 * n];


            for(char[] one: board){
                Arrays.fill(one,'.');
            }

            backtrack(0,n,board,cols,diag1,diag2,res);
            return res;
    }

    static void backtrack(int row, int n , char[][] board, boolean[] cols, boolean[] diag1, boolean[] diag2,List<List<String>> res){

        if(row == n){
            List<String> curr = new ArrayList<>();
            for(char[] one : board){
                curr.add(new String(one));
            }
            res.add(curr);
            return;
        }

        for(int c = 0; c<n; c++){
            int id1 = row+c;
            int id2 = row-c+n;
            if(cols[c]|| diag1[id1]|| diag2[id2]) continue;
            cols[c] = diag1[id1] = diag2[id2] = true;
            board[row][c] = 'Q';
            backtrack(row+1,n,board,cols,diag1,diag2,res);
            cols[c] = diag1[id1] = diag2[id2] = false;
            board[row][c] = '.';


        }


    }

}