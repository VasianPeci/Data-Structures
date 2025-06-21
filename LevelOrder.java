import java.util.NoSuchElementException;

public class LevelOrder<AnyType> extends TreeIterator<AnyType> {
    private ListQueue<BinaryNode<AnyType>> queue;

    public LevelOrder(BinaryTree<AnyType> tree) {
        super(tree);
        queue = new ListQueue<BinaryNode<AnyType>>();
        queue.enqueue(tree.getRoot());
    }

    public void first() {
        queue.makeEmpty();
        if (tree.getRoot() != null) {
            queue.enqueue(tree.getRoot());
            advance();
        }
    }

    public void advance() {
        if (queue.isEmpty()) {
            if (current == null) {
                throw new NoSuchElementException();
            }
            current = null;
            return;
        }

        current = queue.dequeue();
        if (current.getLeft() != null) {
            queue.enqueue(current.getLeft());
        }
        if (current.getRight() != null) {
            queue.enqueue(current.getRight());
        }
    }
}
