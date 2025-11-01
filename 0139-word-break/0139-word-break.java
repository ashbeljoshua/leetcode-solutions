class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {


            if(s==null ) return false;

            Set<String> wordSet = new HashSet<>(wordDict);
            int n = s.length();
            boolean [] dp = new boolean[n+1];
            dp[0] = true;
            for(int i = 0; i<n; i++){
                if(!dp[i]) continue;

                for(String word : wordSet){
                    int len = word.length();
                    int end = i+len;
                    if(end<=n && s.substring(i,end).equals(word)){
                        dp[end] = true;
                    }


                }

            }

        return dp[n];
    }


   
}