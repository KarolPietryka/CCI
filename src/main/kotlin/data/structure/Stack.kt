package data.structure

open class Stack<T>() {
    open class Node<T>(val data: T, var next: Node<T>? = null){
    }
    constructor(headData: T):this(){
        head = Node(headData)
        last = head
    }
    var head: Node<T>? = null
    var last: Node<T>? = null

    open fun push(data: T){
        last = Node(data, last)
        if(head == null) {head = last}
    }
    fun pop(): T?{
        val temp = last
        last = last?.next
        return temp?.data
    }

    fun peek(): T? = last?.data
    override fun toString(): String {
        val sb = StringBuilder((last?.data?.toString() ?: "") + "->")
        var queuePointer = last?.next
        while (queuePointer != null){
            sb.append("${queuePointer.data}")
            if(queuePointer.next != null) {sb.append("->")}
            queuePointer = queuePointer.next
        }
        return sb.toString()
    }

}