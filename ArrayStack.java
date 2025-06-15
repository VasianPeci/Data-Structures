public class ArrayStack<AnyType extends Comparable<AnyType>> {
    private AnyType [] array;
    private int topOfStack;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayStack(){
        array = (AnyType[]) new Comparable[DEFAULT_CAPACITY];
        topOfStack = -1;
    }

    public boolean isEmpty(){
        return topOfStack == -1;
    }

    public void makeEmpty(){
        topOfStack = -1;
    }

    public AnyType top(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[topOfStack];
    }

    public void pop(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        topOfStack--;
    }

    public AnyType topAndPop(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[topOfStack--];
    }

    public void push(AnyType x){
        if (topOfStack == array.length-1) {
            doubleArray();
        }
        array[++topOfStack] = x;
    }

    @SuppressWarnings("unchecked")
    private void doubleArray(){
        AnyType[] newArray = (AnyType []) new Object[array.length*2];
        for (int i = 0; i <= topOfStack; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

}
