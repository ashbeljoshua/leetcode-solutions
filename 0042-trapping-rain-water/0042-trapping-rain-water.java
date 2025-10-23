class Solution {
    public int trap(int[] height) {


        if(height ==null || height.length ==0) return 0;
        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int[] levels = new int[n];
        int sumWater = 0;


        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);

        }
        for(int i = n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        
        for(int i = 0;i<n;i++){
            levels[i] = Math.min(leftMax[i],rightMax[i]);
            if(levels[i]>height[i]){
                sumWater += levels[i]-height[i];
            }
        }
        return sumWater;





    
        
    }
}