package Intro_Lab_Tasks;

public class ArrayQueue {

    private Object[] queue;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int arrayLen) {
        this.queue = new Object[arrayLen];
        this.front = 0;
        this.rear = 0;
	    this.size = 0;
    }

    public void enqueue(Object element) {
        // TODO: Implement enqueue
        if (size == queue.length) {
            System.out.println("Queue Overflow!");
        }else{
            queue rear = element;
            rear = (rear + 1) % queue.length;
        }
    }

    public Object dequeue() {
        // TODO: Implement dequeue
        if (size == 0) {
            System.out.println("Queue Underflow!");
        }else{
            Object rem = queue[front];
            queue[front] = null;
            return rem;
        }
        return null;
    }

    public Object peek() {
        // TODO: Implement peek
        if(size > 0){
            return queue[front];
        }
        return null;
    }

    public boolean isEmpty() {
        // TODO: Implement isEmpty
        if(size == 0){
            return true;
        }
        return false;
    }
}
