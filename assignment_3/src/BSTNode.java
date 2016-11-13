// Steven Hernandez.
// Assignment 3.

public class BSTNode {
    private int value;
    private BSTNode left;
    private BSTNode right;
    int size = 1;

    public BSTNode(int value) {
        this.value = value;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.size++;
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.size++;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public int getSize() {
        return size;
    }

    // size used to determine if two nodes are balanced identically
    public void updateSize() {
        this.size = 1;
        if (null != this.getLeft()) {
            this.size += this.getLeft().getSize();
        }
        if (null != this.getRight()) {
            this.size += this.getRight().getSize();
        }
    }

    public void setSize(int size) {
        this.size = size;
    }
}
