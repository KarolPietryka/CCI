package task.graph;

import data.structure.Stack;
import task.graph.structure.tree.TreeNode;
import task.graph.structure.tree.TreeNodeWithParent;

import java.util.Optional;

//Design an algorithm and write code to find the first common ancestor
//of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
//necessarily a binary search tree.
public class FirstCommonAncestor {
    //Time complexity O(2 log(N)) space complexity O(2 log(N))
    TreeNodeWithParent<Integer> find(TreeNodeWithParent<Integer> firstNode, TreeNodeWithParent<Integer> secNode){
        Stack<TreeNodeWithParent<Integer>> firstStack = pathToStack(firstNode);
        Stack<TreeNodeWithParent<Integer>> secStack = pathToStack(secNode);
        TreeNodeWithParent<Integer> lastCommon = null;
        while (firstStack.peek() == secStack.pop()){
            lastCommon = firstStack.pop();
        }
        return lastCommon;
    }
    private Stack<TreeNodeWithParent<Integer>> pathToStack(TreeNodeWithParent<Integer> treeNode){
        Stack<TreeNodeWithParent<Integer>> stack = new Stack<>();
        while (treeNode != null){
            stack.push(treeNode);
            treeNode = treeNode.getParent();
        }
        return stack;
    }
}
