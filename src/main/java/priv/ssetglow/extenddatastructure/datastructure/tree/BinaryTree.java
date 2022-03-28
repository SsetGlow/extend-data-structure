package priv.ssetglow.extenddatastructure.datastructure.tree;

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

    public boolean remove(T element) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (root == null) {
                return false;
            }
            BinaryTreeNode<T> node = find(element);
            if (node == null) {
                return false;
            }
            if (root.equals(node)) {
                root = null;
                size--;
                return true;
            }
            return remove(root, node);
        } finally {
            lock.unlock();
        }
    }

    public boolean remove(BinaryTreeNode<T> node) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (root == null) {
                return false;
            }
            if (root.equals(node)) {
                root = null;
                size--;
                return true;
            }
            if (node == null) {
                return false;
            }
            return remove(root, node);
        } finally {
            lock.unlock();
        }
    }

    private boolean remove(BinaryTreeNode<T> current, BinaryTreeNode<T> target) {
        if (target.equals(current.getRightChild()) || target.equals(current.getLeftChild())) {
            if (target.isLeaf()) {
                return null == (target.equals(current.getLeftChild()) ? current.setLeftChild(null) : current.setRightChild(null));
            } else if (target.onlyHasLeftChild()) {
                return null != (target.equals(current.getLeftChild()) ? current.setLeftChild(target.getLeftChild()) : current.setRightChild(target.getLeftChild()));
            } else if (target.onlyHasRightChild()) {
                return null != (target.equals(current.getLeftChild()) ? current.setLeftChild(target.getRightChild()) : current.setRightChild(target.getRightChild()));
            } else {
                BinaryTreeNode<T> successor = findSuccessor(target);
                if (!remove(successor)) {
                    throw new RuntimeException("remove successor fail");
                }
                successor.setBoth(target.getLeftChild(), target.getRightChild());
                return null != (target.equals(current.getLeftChild()) ? current.setLeftChild(successor) : current.setRightChild(successor));
            }
        } else if (target.compareTo(current) < 0) {
            return remove(current.getLeftChild(), target);
        } else {
            return remove(current.getRightChild(), target);
        }
    }

    private BinaryTreeNode<T> findSuccessor(BinaryTreeNode<T> current) {
        if (current.isLeaf()) {
            return current;
        }
        return null == current.getLeftChild() ? findSuccessor(current.getRightChild()) : findSuccessor(current.getLeftChild());
    }

    @Nullable
    public BinaryTreeNode<T> find(T element) {
        return find(new BinaryTreeNode<T>(element));
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
        return node.getElement().compareTo(value) < 0 ? find(node.getRightChild(), value) : find(node.getLeftChild(), value);
    }

    public void clear() {
        root = null;
        size = 0;
    }
}
