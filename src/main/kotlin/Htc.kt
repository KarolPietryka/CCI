import task.graph.*
import task.graph.structure.tree.TreeNodeWithParent

fun main() {

    val node = TreeNodeWithParent(1, null).apply {
        left = TreeNodeWithParent(2, this).apply {
            left = TreeNodeWithParent(4, this).apply {
                left = TreeNodeWithParent(8, this)
                right = TreeNodeWithParent(9, this)
            }
            right = TreeNodeWithParent(5, this).apply {
                left = TreeNodeWithParent(10, this)
                right = TreeNodeWithParent(11, this)
            }
        }
        right = TreeNodeWithParent(3, this).apply {
            left = TreeNodeWithParent(7, this).apply {
                left = TreeNodeWithParent(14, this)
                right = TreeNodeWithParent(15, this)
            }
            right = TreeNodeWithParent(6, this).apply {
                right = TreeNodeWithParent(12, this).apply {
                    left = TreeNodeWithParent(13, this)
                }
            }
        }
    }
    println(
        FirstCommonAncestor().findWithCutOnLonger(node.right!!.left as TreeNodeWithParent, node.right!!.right!!.right!!.left!! as TreeNodeWithParent)
    )


}
