package task.arrays;

import java.util.HashMap;

public class PalindromePermutationJ {
    boolean hastListImpl(String stringToTest) {
        int[] occurrenceOfCharacters = new int[128];
        for (char c : stringToTest.toCharArray()) {
            occurrenceOfCharacters[c]++;
        }
        boolean pivotEncountered = false;
        for(int i : occurrenceOfCharacters){
            if(i % 2 != 0){
                if(!pivotEncountered) { pivotEncountered = true; }
                else { return false;}
            }
        }
        return true;
    }
}
