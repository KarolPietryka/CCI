package task.graph

import data.structure.Queue
import task.graph.structure.graph.Graph
import task.graph.structure.graph.Node

// Given a directed graph, design an algorithm to find out whether there is a
//route between two nodes
class RouteBetweenNodes {
    fun findWithDeepStrategy(graph: Graph, toFind: Node): Boolean{
        return searchDeep(graph.nodes.head?.data ?: return false, toFind)
    }
    fun findWithBreadthStrategy(graph: Graph, toFind: Node): Boolean{
        val helperQueue = Queue(graph.nodes.head?.data ?: return false)
        while (!helperQueue.isEmpty()){
            val toCheck = helperQueue.pop() ?: return false
            if(toCheck == toFind) return true
            else {
                toCheck.visited = true
                toCheck.linkedNodes
                    .filter { !it.visited }
                    .forEach{helperQueue.push(it)}
            }
        }
        return false
    }
    private fun searchDeep(current: Node, toFind: Node): Boolean{
        if(current == toFind) return true
        else {
            current.visited = true
            current.linkedNodes.forEach{
                if(searchDeep(it, toFind)) return true
            }
            return false
        }
    }
}