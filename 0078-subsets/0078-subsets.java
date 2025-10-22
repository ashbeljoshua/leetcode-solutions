class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       
       List<List<Integer>> res = new ArrayList<>();

       if(nums==null ||nums.length==0) return res;

       backtrack(0, nums, new ArrayList<>(),res);
       return res;
    }
    static void backtrack(int start, int[] nums, List<Integer> curr, List<List<Integer>> res){

        res.add(new ArrayList<>(curr));

        for(int i = start; i<nums.length; i++){
            curr.add(nums[i]);
            backtrack(i+1,nums,curr, res);
            curr.remove(curr.size()-1);
        }
    }
}

