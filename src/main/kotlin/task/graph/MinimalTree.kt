package task.graph

import task.graph.structure.tree.TreeNode

// Given a sorted (increasing order) array with unique integer elements, write an
//algorithm to create a binary search tree with minimal height.
class MinimalTree {
    companion object {
        @JvmStatic
        fun <T: Comparable<T>>create(collection: Array<T>): TreeNode<T> {
            val half = collection.size/2
            val node = TreeNode(collection[half])
            if(half != 0) {
                node.left = create(collection.sliceArray(0 until collection.size / 2))
                node.right = create(collection.sliceArray(half + 1 until collection.size ))
            }
            return node
        }
    }
}