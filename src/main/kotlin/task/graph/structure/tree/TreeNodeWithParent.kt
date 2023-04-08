package task.graph.structure.tree

class TreeNodeWithParent<T: Comparable<T>>(data: T, val parent: TreeNodeWithParent<T>?) : TreeNode<T>(data) {

    override var left: TreeNode<T>? = null
    override var right: TreeNode<T>? = null
}