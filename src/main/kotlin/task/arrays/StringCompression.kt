package task.arrays
//Implement a method to perform basic string compression using the counts
//of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
//"compressed" string would not become smaller than the original string, your method should return
//the original string. You can assume the string has only uppercase and lowercase letters (a - z).
class StringCompression {
    /**
     * Time complexity: O(N)
     */
    fun compress(stringToCompress: String): String{
        var currentChar = stringToCompress[0]
        var currentCharCounter = 1
        val result = StringBuilder(stringToCompress.length)
        stringToCompress.forEach {
            if(currentChar != it){
                result.append("$currentChar$currentCharCounter")
                currentCharCounter = 1
                currentChar = it
            }else{ currentCharCounter++ }
        }
        result.append("$currentChar$currentCharCounter")
        return if(result.length > stringToCompress.length) { stringToCompress}
        else result.toString()
    }
}