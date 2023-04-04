package task.graph.structure.tree

import data.structure.Queue

class TreeNode<T: Comparable<T>> (val data: T){

    var left: TreeNode<T>? = null
    var right: TreeNode<T>? = null
    fun depth(): Int{
        var depthCounter = 0
        val treeQueue = Queue<TreeNode<T>>()
        treeQueue.push(this)
        while (treeQueue.last != null){
            val last = treeQueue.pop()!!//.let { if(it == null) return else it }
            last.left?.let { treeQueue.push(it) }
            last.right?.let { treeQueue.push(it) }
            depthCounter++
        }
        return depthCounter
    }



}