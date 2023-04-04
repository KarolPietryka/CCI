package task.queues

import data.structure.Stack

//Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
//Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
//threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
//composed of several stacks and should create a new stack once the previous one exceeds capacity.
//SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
//(that is, pop () should return the same values as it would if there were just a single stack).
//FOLLOW UP
//Implement a function popAt(int index) which performs a pop operation on a specific substack.
class StackOfPlates<T> constructor(val capacity: Int){
    val stack: Stack<StackCapacity<T>>? = null

    fun push(data: T){
        if((stack?.last?.data?.last as StackCapacity.NodeWithCapacity).index == capacity){
            stack.push(StackCapacity(data))
        }
        else{ (stack.last as Stack.Node<StackCapacity<T>>).data.push(data) }

    }
    fun push(stack: StackCapacity<T>){
        this.stack?.push(stack)
    }
    fun pop(): T?{
        val poppedStack = stack?.pop() ?: return null
        val poppedStackLast = poppedStack.pop()
        return if( poppedStackLast == null){ pop() }
        else {
            push(poppedStack)
            poppedStackLast
        }
    }
}
class StackCapacity<T> (headData: T): Stack<T>(headData){
    class NodeWithCapacity<T>(data: T, var index: Int = 0, next: Node<T>? ): Node<T>(data, next)
    override fun push(headData: T){
        last = NodeWithCapacity(headData, ++(last as NodeWithCapacity).index, last?.next)
    }
}