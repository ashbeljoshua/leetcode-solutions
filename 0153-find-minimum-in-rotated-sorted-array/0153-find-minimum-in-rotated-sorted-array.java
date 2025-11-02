class Solution {
    public int findMin(int[] nums) {


        if(nums == null || nums.length == 0 ) return 0;

        int left = 0, right = nums.length-1,mid=0;
        if(nums[left] < nums[right] ) return nums[left];
        while(left <right){

            mid = left + (right-left)/2;

            if(nums[mid]>nums[right]){
                left = mid+1;
            }
            else if(nums[mid]<=nums[right]){
                right = mid;
            }

        } 

        return nums[left];

        
    }
}