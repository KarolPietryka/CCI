package task.graph.structure.graph

import data.structure.LinkedList

data class Graph (
    val nodes: LinkedList<Node>,
){
    val size = nodes.size()
    fun root() = nodes[0]?.data
}