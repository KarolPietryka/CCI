package task.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsUniqueJ {
    public boolean bruteForce(String stringToTest){
        List<Character> stringAsArray = new ArrayList<Character>();
        for(char sign: stringToTest.toCharArray()){
            if(stringAsArray.contains(sign)){ return false;}
            else { stringAsArray.add(sign); }
        }
        return true;
    }

    boolean booleanArrayImpl(String str){
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i=0; i < 128; i++){
            if(char_set[str.charAt(i)]) { return false; }
            else { char_set[str.charAt(i)] = true; }
        }
        return true;
    }
    boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i= 0; i < str.length(); i++) {
            int val= str.charAt(i);
            if (char_set[val]) {//Already found this char in string
                return false;
            }
        char_set[val] = true;
        }
        return true;
    }
}
