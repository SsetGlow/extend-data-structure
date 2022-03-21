package priv.ssetglow.extenddatastructure.datastructure.tree;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import priv.ssetglow.extenddatastructure.datastructure.tree.node.BinaryTreeNode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: SsetGlow
 * @since: 0.1
 * @date: 2022-01-06 14:30
 **/
public class BinaryTree<T extends Comparable<T>> {

    private final ReentrantLock lock = new ReentrantLock(true);

    private BinaryTreeNode<T> root;
    private int size;

    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
        size = 1;
    }

    @NotNull
    public void insert(BinaryTreeNode<T> node) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (root == null) {
                root = node;
                size++;
            } else {
                insert(root, node);
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean remove(BinaryTreeNode<T> node) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            BinaryTreeNode<T> targetNode = find(node);
            if (targetNode == null) {
                return false;
            }
            return true;
        } finally {
            lock.unlock();
        }
    }

    private void insert(BinaryTreeNode<T> current, BinaryTreeNode<T> newNode) {
        if (current.compareTo(newNode) < 0) {
            if (current.getRightChild() == null) {
                size++;
                current.setRightChild(newNode);
            } else {
                insert(current.getRightChild(), newNode);
            }
        } else {
            if (current.getLeftChild() == null) {
                size++;
                current.setLeftChild(newNode);
            } else {
                insert(current.getLeftChild(), newNode);
            }
        }
    }

    @Nullable
    public BinaryTreeNode<T> find(BinaryTreeNode<T> node) {
        return find(root, node.getElement());
    }

    @Nullable
    private BinaryTreeNode<T> find(BinaryTreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        if (node.getElement().equals(value)) {
            return node;
        }
        return node.getElement().compareTo(value) < 0 ? find(root.getRightChild(), value) : find(root.getLeftChild(), value);
    }

    public void clear(BinaryTreeNode<T> node) {
        if (node != null) {
            clear(node.getLeftChild());
            clear(node.getRightChild());
            node = null;
        }
    }

    public void clear() {
        root = null;
        size = 0;
    }
}
