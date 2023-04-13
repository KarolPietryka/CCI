package task.recursion;
//Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
//The robot can only move in two directions, right and down, but certain cells are "off limits" such that
//the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
//the bottom right.

import java.util.AbstractMap.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class RobotInGrid {
    public List<String> findPath(int[][] maze){
        LinkedList<String> path = new LinkedList<>();
        SimpleEntry<Integer, Integer> currentPosition = new SimpleEntry(0, 0);
        findPath(maze, path, currentPosition);
        return path;
    }
    void findPath(int[][] maze, LinkedList<String> path,  SimpleEntry<Integer, Integer> currentPosition){
        if(maze.length - 1 == currentPosition.getValue() && maze[maze.length -1].length - 1== currentPosition.getKey()){ return;}
        if(isNextRightValid(maze, currentPosition)){
            findPath(
                maze,
                Optional.of(path).map(it -> {it.add("RBut why "); return it;}).get(),
                new SimpleEntry(currentPosition.getKey() + 1, currentPosition.getValue())
            );
        }
        else if(isNextDownValid(maze, currentPosition)){
            findPath(
                    maze,
                    Optional.of(path).map(it -> {it.add("D"); return it;}).get(),
                    new SimpleEntry(currentPosition.getKey(), currentPosition.getValue() + 1)
            );
        }
        else throw new RuntimeException("there is no way");
    }
    private boolean isNextRightValid(int[][] maze, SimpleEntry<Integer, Integer> currentPosition){
        return maze[currentPosition.getValue()].length > currentPosition.getKey() + 1 && maze[currentPosition.getValue()][currentPosition.getKey() + 1] != 0;
    }
    private boolean isNextDownValid(int[][] maze, SimpleEntry<Integer, Integer> currentPosition) {
        return maze.length > currentPosition.getValue() + 1 && maze[currentPosition.getValue() + 1][currentPosition.getKey()] != 0;
    }
}
