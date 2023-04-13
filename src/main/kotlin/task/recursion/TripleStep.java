package task.recursion;

import java.util.HashMap;

//A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
//steps at a time. Implement a method to count how many possible ways the child can run up the
//stairs.
public class TripleStep {
    int counter = 0;
    public int countPaths(int numberOfSteps){
        if(numberOfSteps < 0 ) return 0;
        else if(numberOfSteps == 0) return 1;
        else return countPaths(numberOfSteps - 1) +
        countPaths(numberOfSteps - 2) +
        countPaths(numberOfSteps - 3);
    }
    public int countWithMemo(int numberOfSteps){
        HashMap<Integer, Integer> memo = new HashMap<>();
        countPaths(numberOfSteps, memo);
        return memo.get(numberOfSteps);
    }
    private int countPaths(int numberOfSteps, HashMap<Integer, Integer> memo){
        if(numberOfSteps < 0 ) return 0;
        else if(numberOfSteps == 0) return 1;
        else if (memo.get(numberOfSteps) != null){
            return memo.get(numberOfSteps);
        }
        else {
            memo.put(numberOfSteps, countPaths(numberOfSteps - 1, memo) +
                countPaths(numberOfSteps - 2, memo) +
                countPaths(numberOfSteps - 3, memo));
            return memo.get(numberOfSteps);
        }
    }
}
