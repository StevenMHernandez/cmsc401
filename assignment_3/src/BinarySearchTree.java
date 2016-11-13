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
        }

        // If `tree` is balanced below,
        // we simply shift the current element value to be the root
        // This helps us keep a balanced tree,
        // even though our data is coming in `in-order`
        if (null == tree.getLeft() && null == tree.getRight()) {
            return insertAsRoot(tree, element);
        }
        if (null != tree.getLeft() && null != tree.getRight()) {
            if (tree.getLeft().getSize() == tree.getRight().getSize()) {
                return insertAsRoot(tree, element);
            }
        }

        if (element < tree.getValue()) {
            tree.setLeft(recInsert(tree.getLeft(), element));
        } else {
            tree.setRight(recInsert(tree.getRight(), element));
        }

        return tree;
    }

    public int[] getSentenceRange(int element) {
        return this.findPosition(this.root, element);
    }


    private int[] findPosition(BSTNode tree, int element) {
        if (element < tree.getValue()) {
            if (null == tree.getLeft()) {
                int a = getPredecessorValue(this.root, element) + 1;
                int b = tree.getValue();
                return new int[]{a, b};
            }

            return findPosition(tree.getLeft(), element);
        } else {
            if (null == tree.getRight()) {
                int a = tree.getValue() + 1;
                int b = getSuccessorValue(this.root, element);
                return new int[]{a, b};
            }

            return findPosition(tree.getRight(), element);
        }
    }

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

    BSTNode rotateLeft(BSTNode tree) {
        BSTNode newTree = tree.getRight();
        if (null == newTree) {
            return tree;
        }
        tree.setRight(newTree.getLeft());
        newTree.setLeft(tree);
        newTree.setSize(tree.getSize());
        tree.updateSize();
        newTree.updateSize();
        return newTree;
    }

    BSTNode rotateRight(BSTNode tree) {
        BSTNode newTree = tree.getLeft();
        if (null == newTree) {
            return tree;
        }
        tree.setLeft(newTree.getRight());
        newTree.setRight(tree);
        newTree.setSize(tree.getSize());
        tree.updateSize();
        newTree.updateSize();
        return newTree;
    }

    BSTNode insertAsRoot(BSTNode tree, int element) {
        if (null == tree) {
            return new BSTNode(element);
        }
        if (element < tree.getValue()) {
            tree.setLeft(this.insertAsRoot(tree.getLeft(), element));
            return this.rotateRight(tree);
        } else {
            tree.setRight(this.insertAsRoot(tree.getRight(), element));
            return this.rotateLeft(tree);
        }
    }
}