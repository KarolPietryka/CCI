package task.arrays
//Given two strings, write a method to decide if one is a permutation of the
//other.

class CheckPermutation {
    /**
     * Time complexity: O(N logN)
     */
    fun bruteForceImpl(first: String, second: String): Boolean{
        val sortedFirst = first.toCharArray().sorted()
        val sortedSecond = second.toCharArray().sorted()
        return sortedFirst == sortedSecond
    }

    /**
     * Time complexity: O(N)
     */
    fun hashListImpl(first: String, second: String): Boolean{
        val hashSet: HashSet<Char> = HashSet()
        hashSet.addAll(first.toCharArray().asList())
        for(sign in second){
            if(!hashSet.contains(sign)) return false
        }
        return true
    }

}