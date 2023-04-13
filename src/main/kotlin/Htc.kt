import task.graph.*
import task.recursion.RobotInGrid

fun main() {

    val maze = arrayOf(
        intArrayOf(1, 0, 1, 0, 1),
        intArrayOf(1, 0, 1, 1, 1),
        intArrayOf(1, 1, 0, 1, 0),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 0, 1)
    )
    println(RobotInGrid().findPath(maze))

}
