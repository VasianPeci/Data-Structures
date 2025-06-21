import java.util.NoSuchElementException;

public class PostOrder<AnyType> extends TreeIterator<AnyType> {
    protected ListStack<StackNode<AnyType>> stack;

    protected static class StackNode<AnyType> {
        BinaryNode<AnyType> node;
        int timesPopped;
        
        StackNode(BinaryNode<AnyType> node) {
            this.node = node;
            timesPopped = 0;
        }
    }

    public PostOrder(BinaryTree<AnyType> tree) {
        super(tree);
        stack = new ListStack<StackNode<AnyType>>();
        stack.push(new StackNode<AnyType>(tree.getRoot()));
    }

    public void first() {
        stack.makeEmpty();
        if (tree.getRoot() != null) {
            stack.push(new StackNode<AnyType>(tree.getRoot()));
            advance();
        }
    }

    public void advance() {
        if (stack.isEmpty()) {
            if (current == null)
                throw new NoSuchElementException();
            current = null;
            return;
        }

        StackNode<AnyType> cNode;
        while (!stack.isEmpty()) {
            cNode = stack.topAndPop();
            if (++cNode.timesPopped == 3) {
                current = cNode.node;
                return;
            }
            stack.push(cNode);
            if (cNode.timesPopped == 1) {
                if (cNode.node.getLeft() != null) {
                    stack.push(new StackNode<AnyType>(cNode.node.getLeft()));
                }
            } else {
                if (cNode.node.getRight() != null) {
                    stack.push(new StackNode<AnyType>(cNode.node.getRight()));
                }
            }
        }
    }
}
