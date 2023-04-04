package task.graph.structure.graph

class Node (
    val linkedNodes: MutableList<Node>,
    val symbol: String? = null,
    var visited: Boolean = false
)