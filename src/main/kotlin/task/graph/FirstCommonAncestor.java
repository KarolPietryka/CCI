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
    public TreeNodeWithParent<Integer> find(TreeNodeWithParent<Integer> firstNode, TreeNodeWithParent<Integer> secNode){
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

    public TreeNodeWithParent<Integer> findWithCutOnLonger(TreeNodeWithParent<Integer> firstNode, TreeNodeWithParent<Integer> secNode) {
        int depthOfFirst = firstNode.depthInTree();
        int depthOfSec = secNode.depthInTree();
        TreeNodeWithParent<Integer> longerPathNode = (depthOfFirst > depthOfSec) ? firstNode : secNode;
        TreeNodeWithParent<Integer> cutLongerPathNode = cutLongerPath(longerPathNode, Math.abs(depthOfFirst - depthOfSec));
        TreeNodeWithParent<Integer> shorterPathNode = (depthOfFirst > depthOfSec) ? secNode : firstNode;
        while (shorterPathNode != null && shorterPathNode.getParent() != null) {
            if (cutLongerPathNode == shorterPathNode) return shorterPathNode;
            else {
                cutLongerPathNode = cutLongerPathNode.getParent();
                shorterPathNode = shorterPathNode.getParent();
            }
        }
        return null;
    }
    private TreeNodeWithParent<Integer> cutLongerPath(TreeNodeWithParent<Integer> longerPathNode, int diff){
        while (diff != 0){
            longerPathNode = longerPathNode.getParent();
            diff--;
        }
        return longerPathNode;
    }

}
