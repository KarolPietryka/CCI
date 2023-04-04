package task.graph

import data.structure.LinkedList
import data.structure.Queue
import task.graph.structure.graph.Graph
import task.graph.structure.tree.TreeNode
import kotlin.math.log2

//Given a binary tree, design an algorithm which creates a linked list of all the nodes
//at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
class ListOfDepths {
    fun create(rootTreeNode: TreeNode<Int>){
        val depth = log2(rootTreeNode.depth().toDouble()).toInt()
        val ll = Array<LinkedList<Int>>(depth) { LinkedList() }
        val depthIdx = 0

        val graphQueue = Queue<Int>(rootTreeNode.data)
        while (graphQueue.peek() != null){
            val current = graphQueue.pop()!!
            ll[depthIdx].add(current)w
        }


    }
}