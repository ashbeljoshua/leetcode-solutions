class Solution {
    public int countSubstrings(String s) {  

        if(s== null || s.length() ==0) return 0;

        int count =0;
        for(int i = 0;i<s.length();i++){
            int countLeft= expand(s,i,i);
            int countRight = expand(s,i,i+1);

            count += countLeft+countRight;

        }

    return count;

    }
    static int expand(String s, int left, int right){

        if(s == null) return 0;
        int count = 0;

        while(left>=0 && right<s.length() && s.charAt(left )==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        
    return count;
       
    }
}