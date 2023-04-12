package task.graph.structure.tree

class TreeNodeWithParent<T: Comparable<T>>(data: T, val parent: TreeNodeWithParent<T>?) : TreeNode<T>(data) {

    override var left: TreeNode<T>? = null
    override var right: TreeNode<T>? = null
    fun depthInTree(): Int{
        var depth = 1
        var currentParent = this.parent
        while (currentParent != null){
            depth++
            currentParent = currentParent.parent
        }
        return depth
    }
}