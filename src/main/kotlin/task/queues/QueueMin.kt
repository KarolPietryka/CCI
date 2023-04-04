package task.queues

import data.structure.Queue
//How would you design a stack which, in addition to push and pop, has a function min
//which returns the minimum element? Push, pop and min should all operate in 0(1) time
class QueueMin(headData: Int) : Queue<Int>(headData) {
    class NodeMin(data: Int, var min: Int, next: NodeMin? = null): Node<Int>(data, next){
    }
    init {
        head = NodeMin(headData, headData)
        last = head
    }

    override fun push(data: Int) {
        last?.next = NodeMin(data, Math.min(data, (last as NodeMin).min))
        last = last?.next
    }
    fun min() = (last as NodeMin).min
}