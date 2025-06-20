public class BinaryTree<AnyType> {
    private BinaryNode<AnyType> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(BinaryNode<AnyType> root) {
        this.root = root;
    }

    public BinaryTree(AnyType element) {
        root = new BinaryNode<AnyType>(element, null, null);
    }

    public BinaryNode<AnyType> getRoot() {
        return root;
    }

    public int size() {
        return BinaryNode.size(root);
    }

    public int height() {
        return BinaryNode.height(root);
    }

    public void printPreOrder() {
        if (root != null) {
            root.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (root != null) {
            root.printPostOrder();
        }
    }

    public void printInOrder() {
        if (root != null) {
            root.printInOrder();
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public void merge(AnyType element, BinaryTree<AnyType> tree1, BinaryTree<AnyType> tree2) {
        if (tree1.root == tree2.root && tree1.root != null) {
            throw new IllegalArgumentException();
        }
        root = new BinaryNode<AnyType>(element, tree1.root, tree2.root);
        if (this != tree1) {
            tree1.makeEmpty();
        }
        if (this != tree2) {
            tree2.makeEmpty();
        }
    }
}
