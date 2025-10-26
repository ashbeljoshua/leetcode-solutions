/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   
   private int[] preorder;
   private int preorderindex;
    private Map<Integer,Integer> inordermap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder== null||inorder == null) return null;
        this.preorder = preorder;
        preorderindex = 0;
        inordermap.clear();
        int inorderlen = inorder.length;
        for(int  i =0;i<inorderlen;i++){
            inordermap.put(inorder[i],i);
        }

      return  build(0,inorderlen-1);


    }

    TreeNode build(int start, int end){

        if(start>end) return null;

        int rootval = preorder[preorderindex++];
        TreeNode root  = new TreeNode(rootval);
        int inorderpos = inordermap.get(rootval);

        root.left = build(start,inorderpos-1);
        root.right = build(inorderpos+1,end);

        return root;


    }
}