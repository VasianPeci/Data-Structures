abstract class TreeIterator<AnyType> {
    protected BinaryTree<AnyType> tree;
    protected BinaryNode<AnyType> current;

    public TreeIterator(BinaryTree<AnyType> tree) {
        this.tree = tree;
        current = null;
    }

    final public boolean isValid() {
        return current != null;
    }

    final public AnyType retrieve() {
        if (!isValid()) {
            throw new RuntimeException("Iterator is not valid");
        }
        return current.getElement();
    }

    abstract public void first();
    abstract public void advance();
}
