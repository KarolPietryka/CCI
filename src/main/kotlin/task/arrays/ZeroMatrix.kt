package task.arrays

//: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//column are set to 0.
class ZeroMatrix {
    fun zeroMatrix(array: Array<IntArray>): Array<IntArray>{
        val zeroElementIndex = mutableMapOf<Int, Int>()
        array.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, el ->
                if(el == 0) zeroElementIndex[rowIndex] = colIndex
            }
        }
        zeroElementIndex.keys.forEach{row->
            array[row] = IntArray(array[0].size){0}
        }
        zeroElementIndex.values.forEach {c ->
            array.forEach { it[c] = 0 }
        }
        return array
    }
}