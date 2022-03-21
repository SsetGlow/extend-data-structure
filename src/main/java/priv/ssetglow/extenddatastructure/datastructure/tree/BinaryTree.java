package priv.ssetglow.extenddatastructure.datastructure.tree;

import org.jetbrains.annotations.NotNull;
import priv.ssetglow.extenddatastructure.datastructure.tree.node.BinaryTreeNode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: SsetGlow
 * @since: 0.1
 * @date: 2022-01-06 14:30
 **/
public class BinaryTree<T extends Comparable<T>> extends Tree<T> {

    private final ReentrantLock lock = new ReentrantLock(true);

    private BinaryTreeNode<T> root;
    private int size;

    public BinaryTree() {
        size = 0;
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
        this.size = 1;
    }

    @NotNull
    public BinaryTreeNode<T> insert(BinaryTreeNode<T> node) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return doInsert(node);
        } finally {
            lock.unlock();
        }
    }

    public boolean remove(BinaryTreeNode<T> node) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return doRemove(node);
        } finally {
            lock.unlock();
        }
    }

    private boolean doRemove(BinaryTreeNode<T> node) {
        if (root == null) {
            return false;
        }
        if (root.equals(node)) {
            return doRemove(root);
        } else if (root.compareTo(node) < 0) {
            return doRemove(root.getRightChild());
        } else {
            return doRemove(root.getLeftChild());
        }
    }

    private BinaryTreeNode<T> doInsert(BinaryTreeNode<T> node) {
        this.size++;
        if (root == null) {
            root = node;
            return root;
        }
        if (root.compareTo(node) < 0) {
            return doInsert(root.getRightChild());
        } else {
            return doInsert(root.getLeftChild());
        }
    }

    public void clear(BinaryTreeNode<T> node) {
        if (node != null) {
            clear(node.getLeftChild());
            clear(node.getRightChild());
            node = null;
        }
    }

    public void clear() {
        this.root = null;
        this.size = 0;
    }
}
