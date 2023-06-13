package task.arrays;

import java.util.*;

public class RottingOranges {
     Queue<String> rott;
     Queue<String> nextRound;
     int freshCounter = 0;
     int rootCounter = 0;
    public int execute(){
        rott = new LinkedList<>();
        nextRound = new LinkedList<>();

//        [[2,1,1],[1,1,0],[0,1,1]]
//        int[][] grid = {
//                {2, 1, 1},
//                {1, 1, 0},
//                {0, 1, 1}};
//        int[][] grid = {
//                {2, 1, 1},
//                {0, 1, 1},
//                {1, 0, 1}};

        //[[0,2]]

        int[][] grid = {{0,2}};
        return orangesRotting(grid);
    }

    public int orangesRotting(int[][] grid) {
        //iterate through the grid
        int counter = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                //if the grid is rotten
                if(grid[i][j] == 2) {
                    //check the surrounding cells
                    rott.add((i + 1) + " " + j);
                    rott.add((i - 1) + " " + j);
                    rott.add(i + " " + (j + 1));
                    rott.add(i + " " + (j - 1));
                }
                else if(grid[i][j] == 1) {
                    //if the grid is fresh
                    freshCounter++;
                }
            }
        }
        while (!rott.isEmpty()){
            oneLvlDfs(grid, rott.poll());
            if(rott.isEmpty() && !nextRound.isEmpty()){
                rott = nextRound;
                nextRound = new LinkedList<>();
                counter++;
            }
        }
        if(rootCounter != freshCounter) {return -1;}
        return counter;
    }
    private void oneLvlDfs(int[][] grid, String ij) {
        int i = Integer.parseInt(ij.split(" ")[0]);
        int j = Integer.parseInt(ij.split(" ")[1]);
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        rootCounter++;

        nextRound.add((i + 1) + " " + j);
        nextRound.add((i - 1) + " " + j);
        nextRound.add(i + " " + (j + 1));
        nextRound.add(i + " " + (j - 1));
    }
}
