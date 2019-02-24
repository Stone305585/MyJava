package interview;

import java.util.Stack;

/**
 * Created by stone on 2016/8/8.
 */
public class QueueUseStack {
    Stack<Integer> curStack = new Stack<Integer>();
    Stack<Integer> tempStack = new Stack<Integer>();
    int peek;

    // Push element x to the back of queue.
    public void push(int x) {
        curStack.push(x);
        if (curStack.size()==1){
            peek = x;
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(curStack.size()>0){
            tempStack.push(curStack.pop());
        }
        tempStack.pop();
        while(tempStack.size()>0){
            curStack.push(tempStack.pop());
            if(curStack.size()==1){
                peek = curStack.peek();
            }
        }
    }

    // Get the front element.
    public int peek() {
        return peek;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return curStack.size()==0;
    }
}

