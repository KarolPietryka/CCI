package task.graph;

import task.graph.structure.tree.TreeNode;

import java.util.Optional;
//
//Implement a function to check if a binary tree is balanced. For the purposes of
//this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
//node never differ by more than one.
public class CheckBalancedJ {
    //Time complexity O(N)
    public Boolean isBalanced(TreeNode<Integer> root){
        if (root == null) {
            return true;
        }
        int leftDepth = getDepth(root.getLeft());
        int rightDepth = getDepth(root.getRight());
        return Math.abs(leftDepth - rightDepth) <= 1;
    }
    private int getDepth(TreeNode<Integer> node){
        if(node == null) { return 0; }
        int leftNodeDepth = Optional.ofNullable(node.getLeft()).map(this::getDepth).orElse(0);
        int rightNodeDepth = Optional.ofNullable(node.getRight()).map(this::getDepth).orElse(0);
        if(Math.abs(leftNodeDepth - rightNodeDepth) > 1){ return Integer.MIN_VALUE; }
        else { return Math.max(leftNodeDepth, rightNodeDepth) + 1; }
    }
}
