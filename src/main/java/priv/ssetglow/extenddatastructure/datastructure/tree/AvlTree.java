package priv.ssetglow.extenddatastructure.datastructure.tree;

import org.jetbrains.annotations.NotNull;
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

    public boolean insert(T element) {
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

    }

}
