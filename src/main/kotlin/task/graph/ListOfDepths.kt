package task.graph

import data.structure.LinkedList
import data.structure.Queue
import task.graph.structure.tree.TreeNode
import kotlin.math.log2

//Given a binary tree, design an algorithm which creates a linked list of all the nodes
//at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
class ListOfDepths {
    fun createWithDeepLvlInsertion(rootTreeNode: TreeNode<Int>): Collection<LinkedList<Int>>{
        var depth = log2(rootTreeNode.depth().toDouble()).toInt()
        val lvlLists = Array<LinkedList<Int>>(++depth) { LinkedList() }
        insertToLvlList(rootTreeNode, lvlLists, 0)
        return lvlLists.toList()
    }
    private fun insertToLvlList(treeNode: TreeNode<Int>, lvlLists: Array<LinkedList<Int>>, level: Int){
        lvlLists[level].add(treeNode.data)
        treeNode.left?.let { insertToLvlList(it, lvlLists, level + 1) }
        treeNode.right?.let { insertToLvlList(it, lvlLists, level + 1) }
    }

    fun createWithBreadth(rootTreeNode: TreeNode<Int>): Collection<LinkedList<Int>>{
        val treeQueue = Queue(rootTreeNode)
        val levelList = mutableListOf<LinkedList<Int>>().apply { this.add(LinkedList()) }
        var visitedNodes: Double = 1.toDouble()
        while (treeQueue.peek() != null){
            val depths = log2(visitedNodes).toInt()
            val currentNode = treeQueue.pop()!!
            if(levelList.size - 1 < depths){
                val newLevelList = LinkedList<Int>().also { it.add(currentNode.data) }
                levelList.add(newLevelList)
            }else {
                levelList[depths].add(currentNode.data)
            }
            currentNode.left?.let { treeQueue.push(it) }
            currentNode.right?.let { treeQueue.push(it) }
            visitedNodes++
        }
        return levelList
    }
}