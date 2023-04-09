package task.graph.structure.graph

class Node (
    val linkedNodes: MutableList<Node>,
    val symbol: String? = null,
    var visited: Boolean = false
){
    constructor(symbol: String):this(mutableListOf(), symbol, false)

    fun addLink(nodeToLink: Node){
        if(!linkedNodes.contains(nodeToLink)){ linkedNodes.add(nodeToLink) }
    }
    override fun equals(other: Any?): Boolean =
        if(other !is Node) false
        else other.symbol == symbol

}