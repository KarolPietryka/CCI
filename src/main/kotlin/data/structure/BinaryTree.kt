package data.structure

class BinaryTree <T: Comparable<T>>{
    private data class Node<T: Comparable<T>>(val data: T, var left: Node<T>? = null, var right: Node<T>? = null){}

    private var root: Node<T>? = null
    fun insert(data: T){
        if(root == null) {root = Node(data)}
        else {insert(data, root!!)}
    }
    private fun insert(data: T, current: Node<T>){
        if(data < current.data){
            if(current.left == null) {current.left = Node(data)}
            else {insert(data, current.left!!)}
        }else if( data == current.data ) {}
        else {
            if(current.right == null) {current.right = Node(data)}
            else {insert(data, current.right!!)}
        }
    }

    fun search(data: T): T? =
        if(root == null) { null }
        else{ search(data, root!!) }

    private fun search(data: T, current: Node<T>): T?{
        return if(data < current.data){
            if(current.left == null) null
            else{
                search(data, current.left!!)
            }
        }else if( data == current.data) current.data
        else {
            if(current.right == null) null
            else {
                search(data, current.right!!)
            }
        }
    }
}