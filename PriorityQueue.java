import java.util.*;

public class PriorityQueue<AnyType> extends AbstractCollection<AnyType> implements Queue<AnyType> {
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;
    private AnyType[] array;
    private Comparator<? super AnyType> cmp;

    public PriorityQueue() {
        currentSize = 0;
        cmp = null;
        array = (AnyType[]) new Object[DEFAULT_CAPACITY + 1];
    }

    public PriorityQueue(Comparator<? super AnyType> c) {
        currentSize = 0;
        cmp = c;
        array = (AnyType[]) new Object[DEFAULT_CAPACITY + 1];
    }

    public PriorityQueue(Collection<? extends AnyType> coll) {
        cmp = null;
        currentSize = coll.size();
        array = (AnyType[]) new Object[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (AnyType item : coll) {
            array[i++] = item;
        }
        buildHeap();
    }

    public int size() {
        return currentSize;
    }

    public void clear() {
        currentSize = 0;
    }

    public AnyType element() {
        if (isEmpty()) throw new NoSuchElementException();
        return array[1];
    }

    public boolean add(AnyType x) {
        if (currentSize == array.length - 1) {
            doubleArray();
        }
        int hole = ++currentSize;
        array[0] = x;

        for (; compare(x, array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }

        array[hole] = x;
        return true;
    }

    public boolean offer(AnyType x) {
        return add(x);
    }

    public AnyType remove() {
        AnyType minItem = element();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public AnyType poll() {
        if (isEmpty()) return null;
        return remove();
    }

    private void percolateDown(int hole) {
        int child;
        AnyType tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && compare(array[child + 1], array[child]) < 0)
                child++;
            if (compare(array[child], tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void doubleArray() {
        AnyType[] temp = (AnyType[]) new Object[array.length * 2];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }

    private int compare(AnyType lhs, AnyType rhs) {
        if (cmp != null)
            return cmp.compare(lhs, rhs);
        return ((Comparable<? super AnyType>) lhs).compareTo(rhs);
    }

    public Iterator<AnyType> iterator() {
        return new Iterator<AnyType>() {
            int index = 1;

            public boolean hasNext() {
                return index <= currentSize;
            }

            public AnyType next() {
                if (!hasNext()) throw new NoSuchElementException();
                return array[index++];
            }
        };
    }
}
