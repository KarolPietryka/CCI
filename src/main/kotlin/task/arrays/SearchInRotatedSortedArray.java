package task.arrays;

public class SearchInRotatedSortedArray {

    public int execute(){

        //int[] nums = {4,5,6,7,0,1,2};
        // [5,1,3]
        int[] nums = {5,1,3};
        int target = 5;
        return search(nums, target);
    }
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) /2;
            if(nums[mid] == target) { return mid; }
            //ex: [3,4,0,1,2,]
            else if(nums[mid] < nums[lo]){
                //ex: [3,4,0,1,2] target = 2
                if(nums[mid] < target && target < nums[lo]){
                    lo = mid + 1;
                }
                //ex: [4,5,0,1,2,3] target = 0, mid = 1
                else {
                    hi = mid - 1;
                }
            }
            //ex: [0,1,2,3,4,5]
            else {
                if(target  < nums[mid] && target >= nums[lo]){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }
}
