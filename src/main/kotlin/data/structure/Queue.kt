package data.structure

import java.util.Stack

open class Queue<T>() {
    open class Node<T>(val data: T, var next: Node<T>? = null){
    }
    constructor(headData: T) : this() {
        head = Node(headData)
        last = head
    }
    var head: Node<T>? = null
    var last: Node<T>? = null


    open fun push(data: T) {
        if(head == null) {
            head = Node(data)
            last = head
        }else {
            last?.next = Node(data)
            last = last?.next
        }
    }
    open fun pop(): T?{
        val headToPop = head
        head = head?.next
        if(head?.next == null){last = head}
        return headToPop?.data
    }
    open fun peek(): T? = head?.data
    fun isEmpty() = head == null && last == null
    override fun toString(): String {
        val sb = StringBuilder(head?.data?.toString() ?: "")
        var queuePointer = head?.next
        while (queuePointer != null){
            sb.insert(0, "${queuePointer.data}<-" )
            queuePointer = queuePointer.next
        }
        return sb.toString()
    }

}
