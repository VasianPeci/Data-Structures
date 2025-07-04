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

    // Queue size
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int count = 0;
        ListNode<AnyType> node = front;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    // print queue
    public static <AnyType> void printQueue(ListQueue<AnyType> queue) {
        ListNode<AnyType> node = queue.front;
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.next;
        }
        System.out.println();
    }

    // invert queue using another queue
    public void invert() {
        ListQueue<AnyType> tempQueue = new ListQueue<AnyType>();
        while (!isEmpty()) {
            tempQueue.enqueue(dequeue());
        }
        int queueSize = tempQueue.size();
        while (!tempQueue.isEmpty()) {
            for (int i = 0; i < queueSize-1; i++) {
                tempQueue.enqueue(tempQueue.dequeue());
            }
            enqueue(tempQueue.dequeue());
            queueSize--;
        }
    }

    // alternate queue1 and queue2 in a single queue
    public static <AnyType> ListQueue<AnyType> merge(ListQueue<AnyType> q1, ListQueue<AnyType> q2) {
        ListQueue<AnyType> queue = new ListQueue<AnyType>();
        ListQueue<AnyType> temp1 = new ListQueue<AnyType>();
        ListQueue<AnyType> temp2 = new ListQueue<AnyType>();
        ListQueue<AnyType> copy = new ListQueue<AnyType>();

        while (!q1.isEmpty()) {
            AnyType temp = q1.dequeue();
            temp1.enqueue(temp);
            copy.enqueue(temp);
        }
        while (!copy.isEmpty()) {
            q1.enqueue(copy.dequeue());
        }

        while (!q2.isEmpty()) {
            AnyType temp = q2.dequeue();
            temp2.enqueue(temp);
            copy.enqueue(temp);
        }
        while (!copy.isEmpty()) {
            q2.enqueue(copy.dequeue());
        }

        while (!temp1.isEmpty() && !temp2.isEmpty()) {
            queue.enqueue(temp1.dequeue());
            queue.enqueue(temp2.dequeue());
        }

        if (temp1.isEmpty() && !temp2.isEmpty()) {
            while (!temp2.isEmpty()) {
                queue.enqueue(temp2.dequeue());
            }
        } else if (temp2.isEmpty() && !temp1.isEmpty()) {
            while (!temp1.isEmpty()) {
                queue.enqueue(temp1.dequeue());
            }
        }
        return queue;
    }
}
