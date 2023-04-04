package task.list.linked

import data.structure.LinkedList

//Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
//intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
//kth node of the first linked list is the exact same node (by reference) as the jth node of the second
//linked list, then they are intersecting.
class Intersection {
    fun <T>haveIntersection(linkedListFirst: LinkedList<T>, linkedListSecond: LinkedList<T>): LinkedList.Node<T>?{
        fun flipList(linkedList: LinkedList<T>): LinkedList<T>{
            var previous = linkedList.head!!
            var current = linkedList.head!!.next
            while (current != null){
                previous.next = current.next
                current.next = linkedList.head
                linkedList.head = current
                current = previous.next
            }
            return linkedList
        }
        val reversedListFirst = flipList(linkedListFirst)
        val reversedListSecond = flipList(linkedListSecond)
        return if(reversedListFirst.head != reversedListSecond.head) {
            null
        } else{
            var currentElementListFirst = reversedListFirst.head!!.next
            var currentElementListSecond = reversedListSecond.head!!.next
            var previous = reversedListFirst.head
            while (currentElementListFirst == currentElementListSecond){
                currentElementListFirst = currentElementListFirst?.next
                currentElementListSecond = currentElementListSecond?.next
                previous = previous?.next
            }
            previous
        }

    }

}