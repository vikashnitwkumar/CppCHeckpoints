import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;



 // Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
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

 public class Node{
    TreeNode node;
    int depth;
     Node(TreeNode node, int depth){
         this.node = node;
         this.depth = depth;
     }
  }

  class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        if(traversal.length() == 0) return null;
        Stack<Node> stack = new Stack<>();
        int depth = 0;
        for(int i = 0; i < traversal.length(); i++){
            if(traversal.charAt(i) == '-'){
                depth++;
            }
            else{
                StringBuilder sb = new StringBuilder();
                int j = i;
                while (j<traversal.length() && traversal.charAt(j) != '-'){
                    sb.append(traversal.charAt(j));
                    j++;
                }
                i = j - 1;
                int val = Integer.parseInt(sb.toString());
                TreeNode node = new TreeNode(val);
                while(!stack.isEmpty() && stack.peek().depth >= depth){
                     stack.pop();
                }
                if(!stack.isEmpty()){
                    if(stack.peek().depth == depth - 1){
                        if(stack.peek().node.left == null){
                            stack.peek().node.left = node;
                        }
                        else{
                            stack.peek().node.right = node;
                        }
                    }                    
                }
                stack.push(new Node(node, depth));
                depth  = 0;
            }
        }
        TreeNode root = stack.peek().node;
        while(!stack.isEmpty()){
            root = stack.pop().node;
        }
        return root;
    }
}