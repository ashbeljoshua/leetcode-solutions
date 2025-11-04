class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for(int  i = 0; i<32; i++){

            int lastDigit = n & 1;
            if(lastDigit == 1) count++;
            n >>>=1;
        }
        return count;
        
    }
}