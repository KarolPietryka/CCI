package task.graph.structure.tree

import data.structure.Queue

open class TreeNode<T: Comparable<T>> (val data: T){

    open var left: TreeNode<T>? = null
    open var right: TreeNode<T>? = null
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

    override fun toString(): String {
        return data.toString()
    }

}