package task.list.linked;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class RemoveDupsJ <T>{
    public List removeDups(LinkedList<T> linkedList){
        LinkedHashSet<T> linkedHashSet = new LinkedHashSet<T>();
        linkedHashSet.addAll(linkedList);
        return Arrays.asList(linkedHashSet);
    }
}
//Implement an algorithm to find the kth to last element of a singly linked list.