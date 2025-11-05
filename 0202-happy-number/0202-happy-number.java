class Solution {
    public boolean isHappy(int n) {

        int slow = n;
        int fast = returnNext(n);

        while( slow != fast &&  fast!=1 ){
            slow = returnNext(slow);
            fast = returnNext(returnNext(fast));

        }

        return fast ==1;
        
    }


    int returnNext(int n ){
        int res = 0;
        while(n != 0){
            int digit = n%10;
            int digitSquare  = digit * digit;
            res += digitSquare ;
            n = n/10;
        }
        return res;

        }

    
}