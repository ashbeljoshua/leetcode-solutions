class Solution {
    public int maxProduct(int[] nums) {
        int maxNow = nums[0];
        int minNow = nums[0];
        int result = nums[0];


        for(int i =1;i<nums.length;i++){

            if(nums[i] <0){

                int temp = maxNow;
                maxNow = minNow;
                minNow = temp;
            }
            maxNow = Math.max(nums[i], maxNow*nums[i]);
            minNow = Math.min(nums[i], minNow*nums[i]);

            result = Math.max(result,maxNow);
        }

      return result;
    }
}