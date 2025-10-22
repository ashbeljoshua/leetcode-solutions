class Solution {
    public boolean exist(char[][] board, String word) {

       if(board == null || board.length == 0 || board[0].length == 0) return false;

       int m = board.length, n =  board[0].length;

       for(int i = 0; i<m;i++){
        for(int j = 0;j<n;j++){
            if(dfs(board,0,i,j,word)){
                return true;
            }
        }
       }
        return false;

    }

    static boolean dfs(char[][] board, int start, int i , int j,String word){
        if(start== word.length() ) return true;
        if(i<0 || j<0 || i>=board.length || j>= board[0].length) return false;
        if(board[i][j] != word.charAt(start)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found;

        found = dfs(board,start+1, i+1, j , word) ||
                dfs(board,start+1, i-1, j, word) ||
                dfs(board,start+1,i,j+1, word) ||
                dfs(board, start+1,i,j-1,word);

        board[i][j]=temp;


        return found;



    }

}