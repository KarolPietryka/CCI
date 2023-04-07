package task.graph;

import task.graph.structure.tree.TreeNode;

import java.util.Optional;
//
//Implement a function to check if a binary tree is balanced. For the purposes of
//this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
//node never differ by more than one.
public class CheckBalancedJ {
    public Boolean isBalanced(TreeNode<Integer> root){
        if (root == null) {
            return true;
        }
        int leftDepth = getDepth(root.getLeft());
        int rightDepth = getDepth(root.getRight());
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(root.getLeft()) && isBalanced(root.getRight());    }
    private int getDepth(TreeNode<Integer> node){
        if(node == null) { return 0; }
        return Math.max(
            Optional.ofNullable(node.getLeft()).map(this::getDepth).orElse(0),
            Optional.ofNullable(node.getRight()).map(this::getDepth).orElse(0))
        + 1;
    }
}
