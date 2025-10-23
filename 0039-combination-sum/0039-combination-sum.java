class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
List<List<Integer>> res = new ArrayList<>();
        
        if(candidates== null|| candidates.length==0) return res;

        Arrays.sort(candidates);
        backtrack(candidates, res, 0, new ArrayList<Integer>(), target);
        return res;
        
    }

    static void backtrack(int[] candidates, List<List<Integer>> res, int start,List<Integer> curr, int rem ){

  if ( rem==0) {

      res.add(new ArrayList<>(curr));
      return;
  }

 for ( int i= start;i< candidates.length; i++)
 {


  int val = candidates[i];
     if ( val > rem) break;

     curr.add(val);
     
     backtrack(candidates,res,i, curr, rem- val);
     curr.remove(curr.size()-1);
 }
        
    }
}