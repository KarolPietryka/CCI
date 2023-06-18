import java.util.*
import java.util.stream.Collectors

class KpSort {
    fun quickSort(arrayList: Array<Int>): Array<Int> {
        if (arrayList.size <= 1) {
            return arrayList
        }
        val pivot = arrayList.last()
        var i = 0
        for (j in 0 until arrayList.lastIndex) {
            if (arrayList[j] < pivot) {
                swapArray(arrayList, i, j)
                i++
            }
        }
        swapArray(arrayList,i, arrayList.lastIndex)
        if(arrayList.size <= 2) return arrayList
        val left = quickSort(arrayList.filterIndexed { index, k -> index < i }.toTypedArray())
        val right = quickSort(arrayList.filterIndexed { index, k -> index > i}.toTypedArray())
        return arrayOf(left, arrayOf(pivot), right).flatten().toTypedArray()
    }
}
fun swapArray(a: Array<Int>, b: Int, c: Int) {
    val temp = a[b]
    a[b] = a[c]
    a[c] = temp
}