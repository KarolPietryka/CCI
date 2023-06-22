package task.graph;

import task.graph.structure.tree.TreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class LowestCommonAncestorOfBinaryTree {
    public TreeNode<Integer> execute(){
//        root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node0 = new TreeNode<>(0);
        TreeNode<Integer> node8 = new TreeNode<>(8);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node4 = new TreeNode<>(4);

        // Connect the nodes to form the binary tree
        node3.setLeft(node5);
        node3.setRight(node1);
        node5.setLeft(node6);
        node5.setRight(node2);
        node1.setLeft(node0);
        node1.setRight(node8);
        node2.setLeft(node7);
        node2.setRight(node4);
        return this.lowestCommonAncestor(node3, node5, node4);

    }
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        Stack<TreeNode<Integer>> pStack = new Stack<>();
        Stack<TreeNode<Integer>> qStack = new Stack<>();
        pStack.add(root);
        qStack.add(root);
        AtomicBoolean bp = new AtomicBoolean(false);
        AtomicBoolean qp = new AtomicBoolean(false);
        findPath(root.getLeft(), p, pStack, bp);
        findPath(root.getRight(), q, qStack, qp);

        HashSet<TreeNode<Integer>>lookup = new HashSet<>();
        while(!pStack.isEmpty()){
            lookup.add(pStack.pop());
        }
        while(!qStack.isEmpty()){
            TreeNode<Integer> temp = qStack.pop();
            if(lookup.contains(temp)){
                return temp;
            }
        }
        return null;
    }
    private void findPath(TreeNode<Integer> root, TreeNode<Integer> lookedFor, Stack<TreeNode<Integer>> queue, AtomicBoolean stop){
        queue.add(root);
        if(root == lookedFor || stop.get()) {stop.set(true); return;}
        if(root.getLeft() != null) findPath(root.getLeft(), lookedFor, queue, stop);
        if(stop.get()) {stop.set(true); return;}
        if(root.getRight() != null) findPath(root.getRight(), lookedFor, queue, stop);
        if(stop.get()) {stop.set(true); return;}
        queue.pop();
    }
}
