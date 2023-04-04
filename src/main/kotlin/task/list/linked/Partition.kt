package task.list.linked

import data.structure.LinkedList

// Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
//before all nodes greater than or equal to x. If x is contained within the list the values of x only need
//to be after the elements less than x (see below). The partition element x can appear anywhere in the
//"right partition"; it does not need to appear between the left and right partitions.
class Partition {
    /**
     * time complexity: O(N(
     */
    fun <T: Comparable<T>>partition(list: LinkedList<T>, partitionPivot: T): LinkedList<T>{
        var previous: LinkedList.Node<T> = list.head!!
        var current :LinkedList.Node<T>? = list.head!!.next
        while (current != null){
            if(current.data < partitionPivot) {
                previous.next = current.next
                current.next = list.head
                list.head = current
                current = previous.next
            }
            else{
                current = current.next
                previous = previous.next!!
            }
        }
        return list
    }
}