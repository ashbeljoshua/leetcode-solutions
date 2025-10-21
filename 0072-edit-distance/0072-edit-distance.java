class Solution {
    public int minDistance(String word1, String word2) {

      if(word1== null || word2 == null){


        if(word1== null && word2 == null) return 0;
        return word1==null ?word2.length():word1.length();

      }
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0]=0;

        for(int i =0;i<=m;i++){
            dp[i][0] = i;
        }
        for(int i = 0;i<=n;i++){
            dp[0][i] = i;
        }

        for(int i =1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{

                    int insert = dp[i][j-1]+1;
                    int delete = dp[i-1][j] +1;
                    int replace = dp[i-1][j-1] +1;
                    dp[i][j] = Math.min(insert,Math.min(delete,replace));
                }


            }
        }

        return dp[m][n];



    }
}