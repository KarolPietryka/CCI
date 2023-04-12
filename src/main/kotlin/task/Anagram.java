package task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {
    public boolean isAnagram(String first, String sec){
        int[] occurrenceMapForFirst = new int[128];
        int[] occurrenceMapForSec = new int[128];
        for(char charAt : first.toCharArray()){
            occurrenceMapForFirst[charAt]++;
        }
        for(char charAt : sec.toCharArray()){
            occurrenceMapForSec[charAt]++;
        }
        return Arrays.stream(occurrenceMapForFirst).boxed().collect(Collectors.toList()).
                equals(Arrays.stream(occurrenceMapForSec).boxed().collect(Collectors.toList()));

    }
}
