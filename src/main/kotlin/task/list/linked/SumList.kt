package task.list.linked

import data.structure.LinkedList


//Sum Lists: You have two numbers represented by a linked list, where each node contains a single
//digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
//function that adds the two numbers and returns the sum as a linked list.
//EXAMPLE
//Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
//Output: 2 -> 1 -> 9. That is, 912.
//FOLLOW UP
//Suppose the digits are stored in forward order. Repeat the above problem.
//Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
//Output: 9 -> 1 -> 2. That is, 912
class SumList {
    fun sumRec(listOne: LinkedList<Int>, listTwo: LinkedList<Int>): LinkedList<Int>{
        val resultList = LinkedList<Int>()
        resultList.head = sum(listOne.head, listTwo.head, 0)
        return resultList
    }
    private fun sum(listOneElement: LinkedList.Node<Int>?, listTwoElement: LinkedList.Node<Int>?, carry: Int): LinkedList.Node<Int>?{
        if(listTwoElement == null && listOneElement == null) {return null}
        val sumValue = (listOneElement?.data ?: 0) + (listTwoElement?.data ?: 0) + carry
        val result: LinkedList.Node<Int>
        if( sumValue > 10 ){
            result = LinkedList.Node(sumValue % 10)
            result.next = sum(listOneElement?.next, listTwoElement?.next, 1)
        }
        else {
            result = LinkedList.Node(sumValue)
            result.next = sum(listOneElement?.next, listTwoElement?.next, 0)
        }
        return result
    }
    fun sum(listOne: LinkedList<Int>, listTwo: LinkedList<Int>): LinkedList<Int>{
        var sizeOfListOne = 0
        var sizeOfListTwo = 0
        var listOneCurrent = listOne.head
        var listTwoCurrent = listTwo.head
        val resultList = LinkedList<Int>()
        while ( listOneCurrent != null){
            listOneCurrent = listOneCurrent.next
            sizeOfListOne++
        }
        while ( listTwoCurrent != null){
            listTwoCurrent = listTwoCurrent.next
            sizeOfListTwo++
        }
        listOneCurrent = listOne.head
        listTwoCurrent = listTwo.head

        val biggerListSize = if(sizeOfListOne < sizeOfListTwo) sizeOfListTwo else sizeOfListOne
        for( i in 0 until biggerListSize){ resultList.add(0) }
        var resultListCurrent = resultList.head

        while (resultListCurrent != null){
            val sumResult = ( listOneCurrent?.data ?: 0 ) + (listTwoCurrent?.data ?: 0) + resultListCurrent.data
            if(sumResult >= 10) {
                resultListCurrent.data = sumResult - 10
                resultListCurrent.next?.let { it.data += 1 }?: resultList.add(1)
            }
            else{
                resultListCurrent.data = sumResult
            }
            listOneCurrent = listOneCurrent?.next
            listTwoCurrent = listTwoCurrent?.next
            resultListCurrent = resultListCurrent.next
        }
        return resultList
    }
}