class Solution {
    public int numDecodings(String s) {

        if(s== null || s.length()==0) return 0;

        int prev2 = 1;
        int prev1  = s.charAt(0) != '0' ? 1 :0;
        if(s.length() ==1 ) return prev1;
        for(int i=1;i<s.length();i++){
            int curr = 0;
            
            char c1 = s.charAt(i);
            char c0 = s.charAt(i-1);

            if(c1-'0'>=1 && c1-'0'<=9) {
                curr += prev1;

            }
            if(c0-'0' != 0){

                int num =( c0 -'0')* 10 +c1-'0';
                if(num>=10 && num <=26){
                    curr += prev2;
                }
            }

            prev2 = prev1;
            prev1 = curr;



        }
        return prev1;


        
    }
}