class Solution {
    public boolean checkValidString(String s) {


        if(s== null || s.length()==0) return false;
        int lowCount=0, highCount=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch== '('){
                lowCount = lowCount+1;
                highCount = highCount+1;
            } else if(ch == ')'){
                lowCount = lowCount-1;
                highCount = highCount-1;
            } else {

                lowCount = Math.max(0, lowCount-1);
                highCount = highCount+1;
            }
            if(highCount<0) return false;

            lowCount = Math.max(0,lowCount);


        }
        return lowCount ==0;

    }
}