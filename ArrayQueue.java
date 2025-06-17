public class ArrayQueue<AnyType> {
    private AnyType[] array;
    private int currentSize;
    private int front;
    private int back;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        array = (AnyType[]) new Object[DEFAULT_CAPACITY];
        makeEmpty();
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
        front = 0;
        back = -1;
    }

    public void enqueue(AnyType x) {
        if (currentSize == array.length) {
            doubleQueue();
        }
        back = increment(back);
        array[back] = x;
        currentSize++;
    }

    public AnyType dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        AnyType result = array[front];
        front = increment(front);
        currentSize--;
        return result;
    }

    public AnyType getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return array[front];
    }

    private int increment(int x) {
        if (++x == array.length) {
            x = 0;
        }
        return x;
    }

    private void doubleQueue(){
        @SuppressWarnings("unchecked")
        AnyType[] newArray = (AnyType[]) new Object[array.length * 2];
        for(int i = 0; i < currentSize; i++, front = increment(front)){
            newArray[i] = array[front];
        }
        array = newArray;
        front = 0;
        back = currentSize-1;
    }
}