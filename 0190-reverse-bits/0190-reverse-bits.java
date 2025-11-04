class Solution {
    public int reverseBits(int n) {
     int reverse = 0;

     for(int i = 0; i<32; i++){
        int lastDigit = n & 1;

        reverse <<=1;
        reverse = reverse | lastDigit;
        n >>>= 1;



     }
     return reverse;

    }
}