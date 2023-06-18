package task.arrays;

        import java.util.ArrayList;
        import java.util.List;

public class Permutation {
    public List<List<Integer>> excute(){
        int[] nums = {1,2,3};
        return permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> current,  int[] nums) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        }
        else{
            for (int i = 0; i < nums.length; i++) {
                if(current.contains(nums[i])) continue;
                current.add(nums[i]);
                backtrack(result, current, nums);
                current.remove(current.size() - 1);
            }
        }

    }
}
