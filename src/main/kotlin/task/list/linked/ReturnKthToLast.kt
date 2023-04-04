package task.list.linked

import data.structure.LinkedList

//Implement an algorithm to find the kth to last element of a singly linked list
class ReturnKthToLast <T>{
    /**
     * Time complexity: O(N)
     */
    fun returnKth(list: LinkedList<T>, kToLast: Int): T{
        var followerElement = list.head!!
        var runnerElement = list[kToLast]
        while (runnerElement != null){
            followerElement = followerElement.next!!
            runnerElement = runnerElement.next
        }
        return followerElement.data
    }
}