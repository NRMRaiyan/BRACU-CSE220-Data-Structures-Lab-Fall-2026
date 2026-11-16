package Intro_Lab_Tasks;

public class ArrayStack {

    private Object[] stack;
    private int top;

    public ArrayStack(int size) {
        stack = new Object[size];
        top = -1;
    }

    public void push(Object element) {
        // TODO: Implement push
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow!");
        }else{
            top++;
            stack[top] = element;
        }
    }

    public Object pop() {
        // TODO: Implement pop
        if (top < 0) {
            System.out.println("Stack Underflow!");
        }else{
            stack[top] = null;
            top--;
        }
        return null;
    }

    public Object peek() {
        // TODO: Implement peek
        if(top < 0){
            return null;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        // TODO: Implement isEmpty
        if(top < 0){
            return true;
        }
        return false;
    }
    
}
