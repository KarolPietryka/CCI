package task.list.linked

import data.structure.LinkedList

class SumList2 {
    fun add(first: LinkedList<Int>, sec: LinkedList<Int>): LinkedList<Int> =
        LinkedList((addRec(first.head, sec.head, 0)))

    private fun addRec(first: LinkedList.Node<Int>?, sec: LinkedList.Node<Int>?, carry: Int): LinkedList.Node<Int>{
        val sumResult = (first?.data ?: 0) + (sec?.data ?: 0) + carry

        return LinkedList.Node(sumResult % 10, kotlin.run {
            if(first == null && sec == null && carry == 0) { null }
            else { addRec(first?.next, sec?.next, if(sumResult >= 10) 1 else 0)}
        })
    }
}