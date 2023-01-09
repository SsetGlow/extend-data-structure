package priv.ssetglow.extenddatastructure.datastructure.tree;

import org.jetbrains.annotations.Contract;
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

    @Contract("_->_")
    public void insert(@NotNull T element) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            insert(new BinaryTreeNode<T>(element));
            size++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    @Contract("_->_")
    protected void insert(@NotNull BinaryTreeNode<T> node) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (root == null) {
                root = node;
                return;
            }
            if (root.getLeftChild() == null) {
                root.setLeftChild(node);
            } else if (root.getRightChild() == null) {
                root.setRightChild(node);
            } else {
                insert(node);
                if (size >= 3 && shouldBalance(node)) {
                    balance(node);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    @Contract("_->_")
    private boolean shouldBalance(@NotNull BinaryTreeNode<T> node) {
        return balanceFactor(node) > 1;
    }

    @Contract("_->_")
    private int balanceFactor(@Nullable BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return nodeHeight(node.getLeftChild()) - nodeHeight(node.getRightChild());
    }

    @Contract("_->_")
    private int nodeHeight(@Nullable BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(nodeHeight(node.getLeftChild()), nodeHeight(node.getRightChild())) + 1;
    }

    @Contract("_->_")
    private void balance(BinaryTreeNode<T> node) {
        if (nodeHeight(node.getRightChild()) - nodeHeight(node.getLeftChild()) > 1) {
            rightRotate(node);
        } else {
            leftRotate(node);
        }
    }

    @Contract("_->_")
    private void leftRotate(@NotNull BinaryTreeNode<T> node) {
        BinaryTreeNode<T> left = node.getLeftChild();
        BinaryTreeNode<T> right = node.getRightChild();
        assert right != null;
        right.setLeftChild(node);
        node.setRightChild(left);
    }

    @Contract("_->_")
    private void rightRotate(@NotNull BinaryTreeNode<T> node) {
        BinaryTreeNode<T> left = node.getLeftChild();
        BinaryTreeNode<T> right = node.getRightChild();
        assert left != null;
        left.setRightChild(node);
        node.setLeftChild(right);
    }

    @Contract("->_")
    public int size() {
        return size;
    }

}
