public class ListStack<AnyType> {
    private ListNode<AnyType> topOfStack;

    public ListStack() {
        topOfStack = null;
    }

    public boolean isEmpty() {
        return topOfStack == null;
    }

    public void makeEmpty() {
        topOfStack = null;
    }

    public void push(AnyType x) {
        topOfStack = new ListNode<AnyType>(x, topOfStack);
    }

    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        topOfStack = topOfStack.next;
    }

    public AnyType top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return topOfStack.element;
    }

    public AnyType topAndPop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        AnyType result = topOfStack.element;
        topOfStack = topOfStack.next;
        return result;
    }
}
