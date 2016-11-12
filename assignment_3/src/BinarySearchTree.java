// Steven Hernandez.
// Assignment 3.

import java.util.ArrayList;
import java.util.List;

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

        // If the tree is balanced below,
        // we simply shift the current element value to be the root
        // This helps us keep a balanced tree,
        // even though our data is coming in `in-order`
        if (null == tree.getLeft() && null == tree.getRight()) {
            return insertRoot(tree, element);
        }
        if (null != tree.getLeft() && null != tree.getRight()) {
            if (tree.getLeft().getSize() == tree.getRight().getSize()) {
                return insertRoot(tree, element);
            }
        }

        if (element < tree.getValue()) {
            tree.setLeft(recInsert(tree.getLeft(), element));
        } else {
            tree.setRight(recInsert(tree.getRight(), element));
        }

        return tree;
    }

    public int[] findRange(int element) {
        // TODO: implement
        return new int[]{0, 1};
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

    BSTNode insertRoot(BSTNode tree, int element) {
        if (null == tree) {
            return new BSTNode(element);
        }
        if (element < tree.getValue()) {
            tree.setLeft(this.insertRoot(tree.getLeft(), element));
            return this.rotateRight(tree);
        } else {
            tree.setRight(this.insertRoot(tree.getRight(), element));
            return this.rotateLeft(tree);
        }
    }
}