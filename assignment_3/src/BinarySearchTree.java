// Steven Hernandez.
// Assignment 3.

public class BinarySearchTree {
    protected BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int element) {
        this.root = this.recInsert(this.root, element);
    }

    private BSTNode recInsert(BSTNode tree, int element) {
        if (tree == null) {
            return new BSTNode(element);
        } else if (element < tree.getValue()) {
            tree.setLeft(recInsert(tree.getLeft(), element));
        } else {
            tree.setRight(recInsert(tree.getRight(), element));
        }

        return tree;
    }

    public int[] getSentenceRange(int element) {
        int a = getPredecessorValue(this.root, element) + 1;
        int b = getSuccessorValue(this.root, element);
        return new int[]{a, b};
    }

    // get the value from the list that would come directly after `value`
    private int getSuccessorValue(BSTNode tree, int value) {
        BSTNode node = null;

        while (null != tree) {
            if (value < tree.getValue()) {
                node = tree;
                tree = tree.getLeft();
            } else if (value > tree.getValue()) {
                tree = tree.getRight();
            } else {
                break;
            }
        }

        return null != node ? node.getValue() : 0;
    }

    // get the value from the list that would come directly before `value`
    private int getPredecessorValue(BSTNode tree, int value) {
        BSTNode node = null;

        while (null != tree) {
            if (value < tree.getValue()) {
                tree = tree.getLeft();
            } else if (value > tree.getValue()) {
                node = tree;
                tree = tree.getRight();
            } else {
                break;
            }
        }

        return null != node ? node.getValue() : 0;
    }
}