// Steven Hernandez.
// Assignment 3.

public class RedBlackTree<T extends Comparable<T>> {
    RedBlackNode<T> root = null;

    public void add(T element) {
        this.root = this.recAdd(this.root, element);
    }

    private RedBlackNode<T> recAdd(RedBlackNode<T> tree, T element) {
        if (tree == null) {
            tree = new RedBlackNode<T>(element);
        } else if (element.compareTo(tree.getValue()) <= 0) {
            tree.setLeft(recAdd(tree.getLeft(), element));
        } else {
            tree.setRight(recAdd(tree.getRight(), element));
        }

        // TODO: handle the red-black aspect of the tree

        return tree;
    }

    public void insert(T s_index) {
        RedBlackNode<T> node = new RedBlackNode(s_index);
    }

    public int[] findRange(int w_index) {
        return new int[]{1,2};
    }
}