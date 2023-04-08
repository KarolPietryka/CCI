package task.graph;

import task.graph.structure.tree.TreeNode;
import task.graph.structure.tree.TreeNodeWithParent;

//Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
//binary search tree. You may assume that each node has a link to its parent
public class Successor {
    //Time complexity O(log n), space complexity O(1)
    public TreeNodeWithParent<Integer> getSuccessor(TreeNodeWithParent<Integer> treeNode){
        if(treeNode.getLeft() != null) { return (TreeNodeWithParent<Integer>) treeNode.getLeft(); }
        else if(treeNode.getRight() != null) {
            TreeNode<Integer> leftSubtreePointer =  treeNode.getRight();
            while (leftSubtreePointer.getLeft() != null){ leftSubtreePointer = leftSubtreePointer.getLeft();}
            return (TreeNodeWithParent<Integer>) leftSubtreePointer;
        }
        else if (treeNode.getParent() != null) { return treeNode.getParent(); }
        else { return treeNode; }
    }
}
