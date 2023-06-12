package task.arrays;

import java.util.Arrays;
public class NumberOfIslands {
    //Give me a tip on how to implement this using DFS
    int rowNum;
    int colNum;
    boolean [][] visited;
    public int execute(){

// grid = [
// ["1","1","0","0","0"],
// ["1","1","0","0","0"],
// ["0","0","1","0","0"],
// ["0","0","0","1","1"]]
        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        return numIslands(grid);
    }
    public int numIslands(char[][] grid) {
        int islNum = 0;
        rowNum = grid.length;
        colNum = grid[0].length;
        visited = new boolean[rowNum][colNum];
        for(boolean[] row : visited){
            Arrays.fill(row, false);
        }
        for(int i = 0; i< rowNum; i++){
            for(int j  = 0; j< colNum; j++){
                if(visited[i][j] || grid[i][j] == '0') {continue;}
                islNum++;
                dfs(grid, i, j);

            }
        }
        return islNum;
    }
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= rowNum || j < 0 || j >= colNum || visited[i][j] || grid[i][j] == '0') return;
        visited[i][j] = true;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
