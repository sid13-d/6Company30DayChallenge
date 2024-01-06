package GoldmanSachs.MaxSumBSTinBT;

import java.util.*;



  //Definition for a binary tree node.
class TreeNode {
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
 
 

 
 class Solution {
    int maxSum=0;
class NodePair{
     public int min, max, sum;
    
 }
    public NodePair getSum(TreeNode root) {
        if(root==null) {
            NodePair a = new NodePair();
            a.min = Integer.MAX_VALUE;
            a.max = Integer.MIN_VALUE;
            a.sum = 0;
            return a;
        }

        NodePair main = new NodePair();
        NodePair left = getSum(root.left);
        NodePair right = getSum(root.right);

        if(left.max < root.val && root.val < right.min) {
            main.min = Math.min(root.val, Math.min(left.min, right.min));
            main.max = Math.max(root.val, Math.max(left.max, right.max));
            main.sum =root.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, main.sum);
        }else {
            main.min=Integer.MIN_VALUE;
            main.max = Integer.MAX_VALUE;
            main.sum = Math.max(left.sum,right.sum);
        }
        return main;
    }
    public int maxSumBST(TreeNode root) {
        NodePair temp = new NodePair();
        temp = getSum(root);
        return maxSum > 0 ? maxSum:0;
    }
}