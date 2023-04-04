package task.queues;

import data.structure.Stack;

//Write a program to sort a stack such that the smallest items are on the top. You can use
//an additional temporary stack, but you may not copy the elements into any other data structure
//(such as an array). The stack supports the following operations: push, pop, peek.
public class SortStack extends Stack<Integer> {
    public SortStack(Integer headData) {
        super(headData);
    }
    
    void sort (){
        Stack<Integer> helperStackFirst = new Stack();
        Stack<Integer> helperStackSec = new Stack();
        while (peek() != null){
            helperStackSec.push(pop());
        }
        while(helperStackSec.peek()!=null) {
            Integer max = helperStackSec.peek();
            while (helperStackSec.peek() != null) {
                Integer pop = helperStackSec.pop();
                max = Math.max(pop, max);
                helperStackFirst.push(pop);
            }
            while (helperStackFirst.peek() != null) {
                Integer pop = helperStackFirst.pop();
                if (max.equals(pop)) {
                    super.push(max);
                } else {
                    helperStackSec.push(pop);
                }
            }
        }

    }

    @Override
    public void push(Integer data) {
        super.push(data);
        sort();
    }
}
