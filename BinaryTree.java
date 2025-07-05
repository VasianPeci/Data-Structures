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

    // max value in binary tree
    public int maxValue(BinaryNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int max = root.getElement();
        int leftMax = maxValue(root.getLeft());
        int rightMax = maxValue(root.getRight());

        return Math.max(max, Math.max(leftMax, rightMax));
    }

    // print even numbers using preOrder traversal
    public void printEven(BinaryNode<Integer> node) {
        if (node == null) {
            System.out.println("Tree is empty");
            return;
        }
        if (node.getElement() % 2 == 0) {
            System.out.print(node.getElement() + " ");
        }
        if (node.getLeft() != null) {
            printEven(node.getLeft());
        }
        if (node.getRight() != null) {
            printEven(node.getRight());
        }
    }

    // find parent of element x
    public BinaryNode<AnyType> parentOf(AnyType x, BinaryNode<AnyType> node) {
        if (node.getElement().equals(x)) throw new RuntimeException("Root does not have parent");
        if (node.getLeft() == null && node.getRight() == null) {
            return null;
        }
        if (node.getLeft().getElement().equals(x) || node.getRight().getElement().equals(x)) {
            return node;
        }
        return parentOf(x, node.getLeft()) != null ? parentOf(x, node.getLeft()) : (parentOf(x, node.getRight()) != null ? parentOf(x, node.getRight()) : null);
    }

    // number of leaf nodes in a tree
    public int leafNodes(BinaryNode<AnyType> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        return leafNodes(root.getLeft()) + leafNodes(root.getRight());
    }

    // number of full nodes
    public int fullNodes(BinaryNode<AnyType> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() != null && root.getRight() != null) {
            return 1 + fullNodes(root.getLeft()) + fullNodes(root.getRight());
        }
        return fullNodes(root.getRight()) + fullNodes(root.getLeft());
    }

    // method for removing nodes in a tree and returning that tree
    public BinaryNode<AnyType> removeLeafNodes(BinaryNode<AnyType> root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return null;
        }
        root.setLeft(removeLeafNodes(root.getLeft()));
        root.setRight(removeLeafNodes(root.getRight()));
        return root;
    }

    // find number of pairs parent-child whose sum is a number k
    public int sumPairs(int k, BinaryNode<Integer> root) {
        if (root == null) return 0;
        if ((root.getLeft() != null && root.getElement() + root.getLeft().getElement() == k) || (root.getRight() != null && root.getElement() + root.getRight().getElement() == k)) {
            return 1 + sumPairs(k, root.getLeft()) + sumPairs(k, root.getRight());
        }
        return sumPairs(k, root.getLeft()) + sumPairs(k, root.getRight());
    }

    // depth of a node with value k
    public int depthOf(AnyType k, BinaryNode<AnyType> root) {
        if (root == null) {
            return -1;
        }
        if (root.getElement().equals(k)) {
            return 0;
        }
        int leftDepth = depthOf(k, root.getLeft());
        if (leftDepth != -1) {
            return leftDepth + 1;
        }
        int rightDepth = depthOf(k, root.getRight());
        if (rightDepth != -1) {
            return rightDepth + 1;
        }
        return -1;
    }
}
