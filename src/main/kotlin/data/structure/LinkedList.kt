package data.structure

class LinkedList<T> {
    class Node<T>(var data: T, var next: Node<T>? = null){
        override fun equals(other: Any?): Boolean {
            return if(other is Node<*>){
                other.data == data
            }else { false }
        }
    }

    var head: Node<T>? = null
    val last = fun (): T? = lastNode()?.data
    fun size():Int{
        var current = head
        var counter = 0
        while (current != null){
            counter++
            current = current.next
        }
        return counter
    }
    fun add(data: T){
        if(head == null) { head = Node(data) }
        else { lastNode()?.let { it.next = Node(data) } }
    }
    fun remove(data: T){
        var previous: Node<T>? = head
        var currentNode: Node<T>? = head.also { if(it == null) return}!!
        while (currentNode != null){
            if(currentNode.data == data){
                if(previous == null){head = currentNode.next}
                else {previous.next = currentNode.next}
            }else{
                previous = currentNode
                currentNode = currentNode.next
            }

        }
    }
    operator fun get(index: Int): Node<T>? {
        var current = head
        var i = 0
        while (current != null && i < index) {
            current = current.next
            i++
        }
        return current
    }
    override fun toString(): String {
        val sb = StringBuilder()
        var current = head
        while (current != null) {
            sb.append(current.data)
            if (current.next != null) {
                sb.append(" -> ")
            }
            current = current.next
        }
        return sb.toString()
    }

    private fun lastNode(): Node<T>? =
        head?.let {
            var last = it
            while (last.next != null) {
                last = last.next!!
            }
            return last
        }
}