package task.list.linked

import java.util.LinkedList
import kotlin.collections.LinkedHashSet

//Remove Dups! Write code to remove duplicates from an unsorted linked list.
//FOLLOW UP
//How would you solve this problem if a temporary buffer is not allowed?
class RemoveDups <T>{
    fun removeDups(linkedList: LinkedList<T>){
        val linkedHashSet: LinkedHashSet<T> = LinkedHashSet()
        linkedList.forEach {
            linkedHashSet.add(it)
        }
    }
    fun removeDupsWithoutBufferUse(linkedList: LinkedList<T>){
        for(index in 0 until linkedList.size){
            for (runnerIndex in index until linkedList.size){
                if(linkedList[index] == linkedList[runnerIndex]){
                    linkedList.removeAt(runnerIndex)
                }
            }
        }
    }
}