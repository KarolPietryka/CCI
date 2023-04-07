import task.graph.*
import task.graph.structure.tree.TreeNode

fun main() {
    val node = TreeNode(5).apply {
        left = TreeNode(4).apply {
            left = TreeNode(3)
            right = TreeNode(5)
        }
        right = TreeNode(6).apply {
            right = TreeNode(7)
        }
    }

    println(ValidateBst().validate(node))

}
