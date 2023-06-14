package task.arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationNoDups {

    public List<List<Integer>> excute(){
        int[] nums = {1,2,3,4,5};
        return permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> current,  int[] nums, int start){
        result.add(new ArrayList<>(current));
        for(int i = start; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(result, current, nums, i+1);
            current.remove(current.size() - 1);
        }
    }
}
