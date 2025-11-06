class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private final TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {   
        List<String> res = new ArrayList<>();    
        for(String word : words){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new TrieNode();
                    
                }
                curr = curr.children[ch-'a'];

            }
            curr.word = word;
        }

        int m = board.length;
        int n = board[0].length;

        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,i,j,root,res); 
               
            }
        }
        return res;
        
    }

    static void dfs(char[][]board, int i , int j , TrieNode curr, List<String> res){

        char  ch = board[i][j];

        if(ch == '#' || curr.children[ch-'a']== null) return;
        curr = curr.children[ch-'a'];

        if(curr.word != null){
            res.add(curr.word);
            curr.word = null;
        }

        board[i][j] = '#';

        if(i >0)   dfs(board,i-1,j, curr,res);
        if(j>0) dfs(board ,i, j-1,curr,res);
        if(i < board.length-1) dfs(board,i+1,j,curr,res);
        if(j < board[0].length-1) dfs(board,i,j+1,curr,res);

        board[i][j] = ch;



    }

  
}