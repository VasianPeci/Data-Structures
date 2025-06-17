public class ListQueue<AnyType> {
    private ListNode<AnyType> front;
    private ListNode<AnyType> back;

    public ListQueue() {
        front = back = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void makeEmpty() {
        front = back = null;
    }

    public void enqueue(AnyType x) {
        if (isEmpty()) {
            front = back = new ListNode<AnyType>(x);
        } else {
            back.next = new ListNode<AnyType>(x);
            back = back.next;
        }
    }

    public AnyType dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        AnyType result = front.element;
        front = front.next;
        return result;
    }

    public AnyType getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.element;
    }
}
