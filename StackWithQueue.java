public class StackWithQueue<AnyType extends Comparable<AnyType>> {
    private ArrayQueue<AnyType> q1 = new ArrayQueue<>();
    private ArrayQueue<AnyType> q2 = new ArrayQueue<>();

    public void push(AnyType x) {
        q1.enqueue(x);
    }

    public AnyType pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");

        while (q1.size() > 1) {
            q2.enqueue(q1.dequeue());
        }

        AnyType top = q1.dequeue();

        while (!q2.isEmpty()) {
            q1.enqueue(q2.dequeue());
        }

        return top;
    }

    public AnyType top() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");

        while (q1.size() > 1) {
            q2.enqueue(q1.dequeue());
        }

        AnyType top = q1.dequeue();

        q2.enqueue(top);

        while (!q2.isEmpty()) {
            q1.enqueue(q2.dequeue());
        }

        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }

    public void printList() {
        int sz = q1.size();
        for (int i = 0; i < sz; i++) {
            AnyType temp = q1.dequeue();
            System.out.println(temp);
            q1.enqueue(temp);
        }
    }
}
