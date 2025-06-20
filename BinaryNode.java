public class BinaryNode<AnyType> {
    private AnyType element;
    private BinaryNode<AnyType> left;
    private BinaryNode<AnyType> right;

    public BinaryNode() {
        this(null, null, null);
    }

    public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public AnyType getElement() {
        return element;
    }

    public BinaryNode<AnyType> getLeft() {
        return left;
    }

    public BinaryNode<AnyType> getRight() {
        return right;
    }

    public void setElement(AnyType element) {
        this.element = element;
    }

    public void setLeft(BinaryNode<AnyType> left) {
        this.left = left;
    }

    public void setRight(BinaryNode<AnyType> right) {
        this.right = right;;
    }

    public static <AnyType> int size(BinaryNode<AnyType> root) {
        if (root != null) {
            return 1 + BinaryNode.size(root.left) + BinaryNode.size(root.right);
        }
        return 0;
    }

    public static <AnyType> int height(BinaryNode<AnyType> root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public BinaryNode<AnyType> duplicate() {
        BinaryNode<AnyType> root = new BinaryNode<AnyType>(element, null, null);
        if (left != null) {
            root.left = left.duplicate();
        }
        if (right != null) {
            root.right = right.duplicate();
        }
        return root;
    }

    public void printPreOrder() {
        System.out.print(element + " ");
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.print(element + " ");
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(element + " ");
        if (right != null) {
            right.printInOrder();
        }
    }
}
