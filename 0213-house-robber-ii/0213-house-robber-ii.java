class Solution {
    public int rob(int[] nums) {

        if(nums == null) return 0;
        if(nums.length == 1) return nums[0];
        int first = checkRob(0, nums.length-2,nums);
        int second = checkRob(1,nums.length-1,nums);
        
        return Math.max(first,second);
        // 0 1 2 3 4 5 
        
    }

    static int checkRob(int i , int j, int[]nums){

        int prev2 = 0;
        int prev1 =  0;
        

        for(int start = i; start<=j;start++){
            int curr = Math.max(prev2+nums[start], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}