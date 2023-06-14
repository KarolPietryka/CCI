package task.arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> execute(){
        //candidates = [2,3,6,7], target = 7
        int[] candidates = {2,3,6,7};
        int target = 7;
        return combinationSum(candidates, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(candidates[i]);
            foo(candidates, target, res, target - candidates[i], temp, i);
        }
        return res;
    }

    private void foo(int[] candidates, int target, List<List<Integer>> res, int current, List<Integer> currentPath, int start){
        if(current == 0){
            res.add(new ArrayList<>(currentPath));
        }
        else if(current < 0){
            return;
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                currentPath.add(candidates[i]);
                foo(candidates, target, res, current - candidates[i], currentPath, i);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }
}
