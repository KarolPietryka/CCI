package task.list.linked

import data.structure.LinkedList

//Implement an algorithm to delete a node in the middle (i.e., any node but
//the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
//that node.
class DeleteMiddleNode{
    fun <T> deleteMiddle(list: LinkedList<T>): LinkedList<T>{
        var follower = list.head
        var middleMan = list.head
        var doubleJumper = list.head
        while (doubleJumper?.next != null){
            if(middleMan !== list.head){ follower = follower?.next}
            middleMan = middleMan?.next
            doubleJumper = doubleJumper.next?.next
        }
        follower!!.next = middleMan!!.next
        return list
    }
}