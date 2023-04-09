package task.graph.structure.graph

import data.structure.LinkedList

open class Graph (
    val nodes: ArrayList<Node>,
){
    constructor():this(ArrayList())
    val size = nodes.size
    fun root() = nodes.getOrNull(0)

    fun get(symbol:String) = nodes.find { it.symbol == symbol }
    fun get(nodeToFind: Node) = nodeToFind.symbol?.let {  get(it) }
    fun add(nodeToAdd: Node) = nodes.add(nodeToAdd)

    inline fun forEach(action: (Node) -> Unit) {
        for (element in nodes) action(element)
    }
}