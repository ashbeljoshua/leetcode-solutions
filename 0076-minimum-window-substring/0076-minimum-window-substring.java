class Solution {
    public String minWindow(String s, String t) {

        if(s== null || t == null) return "";
        if(s.length()<t.length()) return "";

        int[] tchar = new int[128];
        int[] schar = new int[128];
        int required = 0, have = 0, left =0,bestLeft = 0, minLength = Integer.MAX_VALUE;
        for (char c : t.toCharArray()){

            if(tchar[c]==0) required++;
            tchar[c]++;
        }

        for(int right = 0; right<s.length(); right++){

            char c = s.charAt(right);

            schar[c]++;

            if(tchar[c]>0 && schar[c]==tchar[c]) have++;

            while(required == have){

                if(right-left+1 < minLength){
                    minLength = right-left+1;
                    bestLeft = left;
                }
                
                schar[s.charAt(left)]--;
                if(tchar[s.charAt(left)]>0 && tchar[s.charAt(left)] > schar[s.charAt(left)]){
                        have--;
                }
                left++;

            }




        }


        return minLength == Integer.MAX_VALUE ? "": s.substring(bestLeft, bestLeft+minLength);
        
    }
}