import task.graph.*
import task.graph.structure.tree.TreeNodeWithParent

fun main() {
    val node = TreeNodeWithParent(9, null).apply {
        left = TreeNodeWithParent(6, this).apply {
            right = TreeNodeWithParent(8, this).apply {
                left = TreeNodeWithParent(7, this)
            }
        }
        right = TreeNodeWithParent(16, this).apply {
            left = TreeNodeWithParent(11, this)
        }
    }

    println(Successor().getSuccessor((node.left) as TreeNodeWithParent<Int>))

}
