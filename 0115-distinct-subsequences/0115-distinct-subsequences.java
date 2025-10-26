class Solution {
    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();
        if(m<n) return 0;
        
        int[] []dp = new int[m+1][n+1];

        // ways to make emtprty s from emtpy t is 1
        dp[0][0] = 1;

        // if t is empty , ways to make emtpy t from all s is delete all 1 way
        for(int i=1;i<=m;i++){
            dp[i][0] = 1;

         }

        // if s is emptry , t cannot be made which is 0 . No need of below since deault value 0
        // for(int i = 1;i<=n;i++){
            //dp[0][i] =0;
        //}

        for(int i = 1;i<=m;i++){
            char schar = s.charAt(i-1);
            for(int j = 1;j<=n;j++){
                char tchar = t.charAt(j-1);

                dp[i][j] = dp[i-1][j];
                if(schar==tchar){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }

        return dp[m][n];
    }
}