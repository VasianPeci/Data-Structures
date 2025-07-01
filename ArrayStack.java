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

    // size of stack
    public int size(){
        return topOfStack + 1;
    }

    // print stack
    public void printStack(){
        if (topOfStack == -1) {
            System.out.println("Stack is empty");
        } else {
            for (int i = topOfStack; i >= 0; i--) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    // sort stack
    public void sortStack(){
        for (int i = 0; i <= topOfStack; i++) {
            for (int j = 0; j < topOfStack-i; j++) {
                if (array[j+1].compareTo(array[j]) < 0) {
                    AnyType temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // copy to other stack
    public void copyToOtherStack(ArrayStack<AnyType> otherStack){
        otherStack.makeEmpty();
        for (int i = 0; i <= topOfStack; i++) {
            otherStack.push(array[i]);
        }
    }

    // max binary number (we suppose stacks contain binary numbers where each element is either 1 or 0)
    public static <AnyType extends Comparable<AnyType>> int maxBinaryNumber(ArrayStack<Integer> stack1, ArrayStack<Integer> stack2){
        // find stack1 number in decimal
        int number1 = 0;
        for (int i = stack1.topOfStack; i >= 0; i--) {
            number1 += Math.pow(2, i) * stack1.array[i];
        }

        // find stack2 number in decimal
        int number2 = 0;
        for (int i = stack2.topOfStack; i >= 0; i--) {
            number2 += Math.pow(2, i) * stack2.array[i];
        }

        // compare both numbers
        if (number1 > number2) {
            return number1;
        }
        return number2;
    }

    // move element at k index to top of stack
    public void moveElementToTop(int k){
        if (k < 0 || k > topOfStack) {
            System.out.println("Index k out of bounds");
            return;
        }
        for (int i = k; i < topOfStack; i++) {
            AnyType temp = array[i];
            array[i] = array[i+1];
            array[i+1] = temp;
        }
    }
}
