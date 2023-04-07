package task.graph;

import task.graph.structure.tree.TreeNode;

import javax.swing.text.html.Option;
import java.util.Optional;

// Implement a function to check if a binary tree is a binary search tree.
public class ValidateBst {
    //Time complexity O(n), space complexity O(N)
    public boolean validate(TreeNode<Integer> rootNode){
        Integer currentData = rootNode.getData();
        if(Optional.ofNullable(rootNode.getLeft()).map(TreeNode::getData).orElse(Integer.MIN_VALUE) <= currentData
            && Optional.ofNullable(rootNode.getRight()).map(TreeNode::getData).orElse(Integer.MAX_VALUE) >= currentData){
            return Optional.ofNullable(rootNode.getLeft()).map(this::validate).orElse(true)
                    && Optional.ofNullable(rootNode.getRight()).map(this::validate).orElse(true);
        }
        return false;
    }
}
