package task.graph;

import data.structure.LinkedList;
import data.structure.Queue;
import task.graph.structure.tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;


public class ListOfDepthsJ {
    public Collection<LinkedList<Integer>> createWithDeepLvlInsertion(TreeNode<Integer> treeNode){
        int depth = (int)(Math.log(treeNode.depth())/Math.log(2));
        LinkedList<Integer>[] lvlList = new LinkedList[depth];
        for(int i = 0; i < lvlList.length; i++){
            lvlList[i] = new LinkedList<>();
        }
        this.insertToLvlList(treeNode, lvlList, 0);
        return new ArrayList<>(Arrays.asList(lvlList));
    }
    private void insertToLvlList(TreeNode<Integer> treeNode, LinkedList<Integer>[] lvlList, int level){
        lvlList[level].add(treeNode.getData());
        this.insertToLvlList(Objects.requireNonNull(treeNode.getLeft()), lvlList, ++level);
        this.insertToLvlList(Objects.requireNonNull(treeNode.getRight()), lvlList, ++level);
    }
    public Collection<LinkedList<Integer>> createWithBreadth(TreeNode<Integer> rootTreeNode){
        int visitedNodes = 1;
        ArrayList<LinkedList<Integer>> levelList = new ArrayList<>();
        levelList.add(new LinkedList<>());
        Queue<TreeNode<Integer>> levelQueue = new Queue<>(rootTreeNode);
        while (levelQueue.peek() != null){
            TreeNode<Integer> currentNode = levelQueue.pop();
            int depth = (int)(Math.log(visitedNodes)/Math.log(2)) + 1;
            if(depth > levelList.size()){
                LinkedList<Integer> newLevelList = new LinkedList<>();
                assert currentNode != null;
                newLevelList.add(currentNode.getData());
                levelList.add(newLevelList);
            }else{
                assert currentNode != null;
                levelList.get(levelList.size() -1 ).add(Optional.of(currentNode).get().getData());
            }
            Optional.ofNullable(currentNode.getLeft()).ifPresent(levelQueue::push);
            Optional.ofNullable(currentNode.getRight()).ifPresent(levelQueue::push);
            visitedNodes++;
        }
        return levelList;
    }

    public Collection<LinkedList<Integer>> createWithListDive(TreeNode<Integer> rootTreeNode){
        ArrayList<LinkedList<TreeNode<Integer>>> levelList = new ArrayList<>();
        LinkedList<TreeNode<Integer>> currentLvl = new LinkedList<>();
        currentLvl.add(rootTreeNode);
        while (currentLvl.size() > 0){
            levelList.add(currentLvl);
            LinkedList<TreeNode<Integer>> parentLvl = currentLvl;
            LinkedList.Node<TreeNode<Integer>> parent = parentLvl.getHead();
            currentLvl = new LinkedList<>();
            while (parent != null){
                Optional.ofNullable(parent.getData().getLeft()).ifPresent(currentLvl::add);
                Optional.ofNullable(parent.getData().getRight()).ifPresent(currentLvl::add);
                parent = parent.getNext();
            }
        }
        return levelList.stream().map(level -> {
            LinkedList.Node<TreeNode<Integer>> c = level.getHead();
            LinkedList<Integer> res = new LinkedList<>();
            while (c != null) {
                res.add(c.getData().getData());
                c = c.getNext();
            }
            return res;
            }
        ).collect(Collectors.toList());
    }
}
