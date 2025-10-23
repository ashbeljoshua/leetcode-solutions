class Solution {
    public int[] plusOne(int[] digits) {

        if(digits == null || digits.length == 0) return new int[]{0};

        int  carr = 1, curr = 0, n = digits.length;

        for(int i = n-1;i>=0; i--){
            curr = carr + digits[i];
            digits[i] = curr % 10;
            carr = curr/10;
            if(carr == 0 ) break;

        }

        if(carr >0){

            int[] result = new int[n+1];
            int m = result.length;
            result[0] = carr;
            for(int i=1;i<m;i++){
                result[i] = digits[i-1];
            }
            return result;

        }

        return digits;
        
    }
}