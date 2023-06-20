package task.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] execute(){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        return merge(intervals);
    }
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(o1,o2)->Integer.compare(o1[0], o2[0]));
        List<int[]> ansList = new ArrayList<int[]>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int e,s;
        for(int i =1; i<intervals.length;i++) {
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }else{
                ansList.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ansList.add(new int[] {start,end});
        ansList.forEach((int[] a)-> System.out.println(a[0]+" "+a[1]));
        return ansList.toArray(new int[ansList.size()][]);
    }
}
