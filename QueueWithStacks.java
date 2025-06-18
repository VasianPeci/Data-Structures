public class QueueWithStacks<AnyType extends Comparable<AnyType>> {
    private ArrayStack<AnyType> stack1;
    private ArrayStack<AnyType> stack2;

    public QueueWithStacks() {
        stack1 = new ArrayStack<>();
        stack2 = new ArrayStack<>();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public void makeEmpty() {
        stack1.makeEmpty();
    }

    public void enqueue(AnyType x) {
        stack1.push(x);
    }

    public AnyType dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.topAndPop());
        }
        AnyType result = stack2.topAndPop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.topAndPop());
        }
        return result;
    }

    public int size() {
        return stack1.size();
    }

    public AnyType getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.topAndPop());
        }
        AnyType result = stack2.top();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.topAndPop());
        }
        return result;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.topAndPop());
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.top() + " ");
            stack1.push(stack2.topAndPop());
        }
        System.out.println();
    }
}
