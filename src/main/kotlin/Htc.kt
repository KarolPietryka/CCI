import data.structure.LinkedList
import task.graph.*
import task.graph.structure.BuildOrderJ
import task.graph.structure.tree.TreeNodeWithParent
import task.list.linked.SumList2


fun main() {
    val list1 = LinkedList<Int>()
    list1.add(7)
    list1.add(1)
    list1.add(6)

    val list2 = LinkedList<Int>()
    list2.add(5)
    list2.add(9)
    list2.add(2)

    val sumList = SumList2()
    val result = sumList.add(list1, list2)

    println("Input: $list1 + $list2")
    println("Output: $result")


}
