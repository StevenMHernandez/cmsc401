// Steven Hernandez.
// Assignment 3.

public class RedBlackNode<T extends Comparable<T>> {
    private boolean black = false;
    private RedBlackNode<T> left = null;
    private RedBlackNode<T> right = null;
    private T value;

    public RedBlackNode(T value) {
        this.value = value;
    }

    public RedBlackNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(RedBlackNode<T> left) {
        this.left = left;
    }

    public RedBlackNode<T> getRight() {
        return this.right;
    }

    public void setRight(RedBlackNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isBlack() {
        return this.black;
    }
}
