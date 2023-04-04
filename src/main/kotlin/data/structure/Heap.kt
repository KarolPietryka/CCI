package data.structure

class Heap<T: Comparable<T>> {
    private val heapList = mutableListOf<T>()
    fun insert(data: T){
        heapList.add(data)
        moveUp(heapList.size - 1)
    }
    private fun moveUp(index: Int){
        var parent = index/2
        var child = index
        while(heapList[child] > heapList[parent] && child > 0) {
            swap( child, parent)
            child = parent
            parent = child/2
        }
    }
    private fun swap(firstIndex: Int, secondIndex: Int){
        val temp = heapList[secondIndex]
        heapList[secondIndex] = heapList[firstIndex]
        heapList[firstIndex] = temp
    }
}