public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    protected BinaryNode<AnyType> root;

    public BinarySearchTree(BinaryNode<AnyType> root) {
        this.root = root;
    }

    public AnyType elementAt(BinaryNode<AnyType> node) {
        return node == null ? null : node.getElement();
    }

    public BinaryNode<AnyType> find(AnyType x, BinaryNode<AnyType> node) {
        while (node != null) {
            if (x.compareTo(node.getElement()) < 0) {
                node = node.getLeft();
                continue;
            }
            if (x.compareTo(node.getElement()) > 0) {
                node = node.getRight();
                continue;
            }
            return node;
        }
        return null;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> node) {
        if (node != null) {
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
        }
        return node;
    }

    public BinaryNode<AnyType> findMax(BinaryNode<AnyType> node) {
        if (node != null) {
            while (node.getRight() != null) {
                node = node.getRight();
            }
        }
        return node;
    }

    protected BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> node) {
        if (node == null) {
            node = new BinaryNode<AnyType>(x, null, null);
        } else if (x.compareTo(node.getElement()) < 0) {
            node.setLeft(insert(x, node.getLeft()));
        } else if (x.compareTo(node.getElement()) > 0) {
            node.setRight(insert(x, node.getRight()));
        } else {
            throw new RuntimeException("Duplicate item");
        }
        return node;
    }

    protected BinaryNode<AnyType> removeMin(BinaryNode<AnyType> node) {
        if (node == null) {
            throw new RuntimeException("Empty tree");
        }
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(removeMin(node.getLeft()));
        return node;
    }

    protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> node) {
        if (node == null) {
            throw new RuntimeException("Element not found in the tree.");
        }
        else if (x.compareTo(node.getElement()) > 0) {
            node.setRight(remove(x, node.getRight()));
        }
        else if (x.compareTo(node.getElement()) < 0) {
            node.setLeft(remove(x, node.getLeft()));
        } else {
            if (node.getLeft() != null && node.getRight() != null) {
                node.setElement(findMin(node.getRight()).getElement());
                node.setRight(removeMin(node.getRight()));
            } else {
                node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
            }
        }
        return node;
    }

    // find parent of element x
    public BinaryNode<AnyType> parentOf(AnyType x, BinaryNode<AnyType> node) {
        if (node.getElement().equals(x)) {
            throw new RuntimeException("Root does not have parent");
        }
        if (node.getLeft() != null && node.getRight() != null) {
            if (node.getLeft().getElement().equals(x) || node.getRight().getElement().equals(x)) {
                return node;
            }
            if (x.compareTo(node.getElement()) < 0) {
                return parentOf(x, node.getLeft());
            }
            return parentOf(x, node.getRight());
        }
        if (node.getLeft() != null) {
            if (node.getLeft().getElement().equals(x)) {
                return node;
            } else {
                return parentOf(x, node.getLeft());
            }
        }
        if (node.getRight() != null) {
            if (node.getRight().getElement().equals(x)) {
                return node;
            } else {
                return parentOf(x, node.getRight());
            }
        }
        return null;
    }
}
