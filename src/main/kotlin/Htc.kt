import data.structure.LinkedList
import task.graph.ListOfDepths
import task.graph.ListOfDepthsJ
import task.graph.MinimalTree
import task.graph.structure.graph.Graph
import task.graph.structure.graph.Node
import task.graph.RouteBetweenNodes
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

    val levelLists = ListOfDepthsJ().createWithListDive(node)
    for (levelList in levelLists) {
        println(levelList)
    }
}
