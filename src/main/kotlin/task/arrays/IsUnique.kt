package task.arrays

//Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
//cannot use additional data structures?
class IsUnique {
    /**
     * Time complexity: O(N)
     */
    fun bruteForce(stringToTest: String): Boolean{
        val duplicationSearcherArray = mutableListOf<Char>()
        for(n in stringToTest){
            if(duplicationSearcherArray.contains(n)) { return false }
            else {duplicationSearcherArray.add(n)}
        }
        return true
    }

    /**
     * Time complexity: O(N logN)
     */
    fun onSortBase(stringToTest: String): Boolean{
        var lastChecked: Char? = null
        for(n in stringToTest.toCharArray().sorted()){
            if(n == lastChecked) { return false }
            lastChecked = n
        }
        return true
    }

    fun booleanArrayImpl(stringToTest: String): Boolean{
        val characters = BooleanArray(128) { false }
        for (signIndex in 0 .. 128){
            if(characters[stringToTest[signIndex].code]){ return false }
            else {characters[stringToTest[signIndex].code] = true}
        }
        return true
    }

}