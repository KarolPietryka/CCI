package task.arrays

class PalindromePermutation {
//    fun bruteForce(stringToTest: String){
//        val linkedList = LinkedList<String>()
//        stringToTest.toCharArray().sorted().let {
//            val last: String? = null
//
//        }
//    }
    fun hastMapImpl(stringToTest: String): Boolean{
        val hashMapForString = mutableMapOf<Char, Int>()
        stringToTest.forEach {
            hashMapForString[it] = hashMapForString.getOrDefault(it, 0) + 1
        }
        var pivotEncountered = false
        hashMapForString.values.forEach{
            if( it % 2 != 0){
                if(!pivotEncountered) { pivotEncountered = true}
                else { return false }
            }
        }
        return true
    }
    fun stringArrayImpl(stringToTest: String): Boolean{
        var pivotEncountered = false
        val stringArray = IntArray(128){ 0 }
        stringToTest.forEach {
            stringArray[it.code]++
        }
        for(element in stringArray){
            if(element % 2 == 0){
                if(!pivotEncountered) { pivotEncountered = true}
                else { return false }
            }
        }
        return true
    }
}