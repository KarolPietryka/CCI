import task.graph.*
import task.graph.structure.BuildOrderJ
import task.graph.structure.tree.TreeNodeWithParent
import java.util.*


fun main() {
    val projects = listOf("a", "b", "c", "d", "e", "f")
    val dependencies = listOf(
        Pair("a", "d"),
        Pair("f", "b"),
        Pair("b", "d"),
        Pair("f", "a"),
        Pair("d", "c")
    ).toMap()

    println(BuildOrderJ().getOrder(projects, dependencies))

}
