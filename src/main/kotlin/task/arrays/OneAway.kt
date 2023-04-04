package task.arrays

import kotlin.math.abs
//: There are three types of edits that can be performed on strings: insert a character,
//remove a character, or replace a character. Given two strings, write a function to check if they are
//one edit (or zero edits) away.
class OneAway {
    /**
     * Time complexity: O(N)
     */
    fun charArrayImpl(first: String, second: String): Boolean{
        if(first == second) { return true }
        val firstCharOccurrenceArray = IntArray(128){0}
        val secondCharOccurrenceArray = IntArray(128){0}

        first.forEach {
            firstCharOccurrenceArray[it.code]++
        }
        second.forEach {
            secondCharOccurrenceArray[it.code]++
        }
        val subtractionArray = IntArray(128)
        firstCharOccurrenceArray.forEachIndexed { index, i ->
            subtractionArray[index] = abs(i - secondCharOccurrenceArray[index])
        }
        if(first.length == second.length){
            return subtractionArray.sum() == 2
        }else{
            return subtractionArray.sum() == 1
        }
    }
    /**
     * Time complexity: O(N)
     */
    fun shorterOneIterationImpl(first: String, second: String): Boolean{
        if(first.length + 1 == second.length){ edit(first.toCharArray(), second.toCharArray())}
        else if(first.length -1 == second.length){ edit(second.toCharArray(), first.toCharArray())}
        else if(first.length == second.length){}
        return false

    }
    private fun edit(shorter: CharArray, longer: CharArray): Boolean{
        var diffEncountered = false
        var shorterIdx = 0
        var longerIdx = 0
        shorter.forEach {
            if(shorter[shorterIdx] != longer[longerIdx]){
                if(!diffEncountered) {
                    diffEncountered = true
                    longerIdx++
                }else{ return false }
            }else {
                shorterIdx++
                longerIdx++
            }
        }
        return true
    }
}