package priv.ssetglow.extenddatastructure.datastructure.tree;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import priv.ssetglow.extenddatastructure.datastructure.tree.node.BinaryTreeNode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SsetGlow
 * @date 2022-01-06 14:22
 * @since 0.1
 **/
public class AvlTree<T extends Comparable<T>> extends BinaryTree<T> {

    private final ReentrantLock lock = new ReentrantLock(true);

    private BinaryTreeNode<T> root;
    private int size;

    public AvlTree(@NotNull BinaryTreeNode<T> root) {
        this.root = root;
        size++;
    }

    public boolean insert(@NotNull T element) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            BinaryTreeNode<T> node = new BinaryTreeNode<T>(element);
            size++;
        } finally {
            lock.unlock();
        }
        return false;
    }

    @Override
    public void insert(@NotNull BinaryTreeNode<T> node) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }
    }

    private boolean shouldBalance(@NotNull BinaryTreeNode<T> node) {
        return balanceFactor(node) > 1;
    }

    private int balanceFactor(@Nullable BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return nodeHeight(node.getLeftChild()) - nodeHeight(node.getRightChild());
    }

    private int nodeHeight(@Nullable BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(nodeHeight(node.getLeftChild()), nodeHeight(node.getRightChild())) + 1;
    }

    private void leftRotate() {

    }

    private void rightRotate() {

    }

}
