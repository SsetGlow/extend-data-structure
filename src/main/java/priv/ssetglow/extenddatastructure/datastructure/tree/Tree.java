package priv.ssetglow.extenddatastructure.datastructure.tree;

import org.jetbrains.annotations.NotNull;
import priv.ssetglow.extenddatastructure.datastructure.tree.node.TreeNode;

import java.io.Serial;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: SsetGlow
 * @since: 0.1
 * @date: 2022-01-06 14:21
 **/
public class Tree<T extends Comparable<T>> implements Serializable {

    @Serial
    private static final long serialVersionUID = 0b1L;

    protected @NotNull AtomicInteger size = new AtomicInteger();
    private TreeNode<T> root;

    private final ReentrantLock putLock = new ReentrantLock();
    private final ReentrantLock takeLock = new ReentrantLock();
    private final ReentrantLock updateLock = new ReentrantLock();

    public void fullyLock() {
        this.putLock.lock();
        this.takeLock.lock();
        this.updateLock.lock();
    }

    public void fullyUnlock() {
        this.putLock.unlock();
        this.takeLock.unlock();
        this.updateLock.unlock();
    }

    public Tree() {
        this.size.set(0);
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
        this.size.set(1);
    }

    public boolean isEmpty() {
        return null == this.root;
    }

    public int height(TreeNode<T> node) {
        return 0;
    }

    public int size() {
        return this.size.get();
    }

    public boolean insert(TreeNode<T> node) {
        ReentrantLock putLock = this.putLock;
        boolean res;
        putLock.lock();
        try {
            res = this.root.addChildNode(node);
        } finally {
            putLock.unlock();
        }
        return res;
    }

    public boolean remove(TreeNode<T> node) {
        ReentrantLock takeLock = this.takeLock;
        boolean res;
        takeLock.lock();
        try {
            res = this.root.removeChildNode(node);
        } finally {
            takeLock.unlock();
        }
        return res;
    }

    public boolean update(TreeNode<T> treeNode) {
        ReentrantLock updateLock = this.updateLock;
        boolean res;
        updateLock.lock();
        try {
            res = false;
        } finally {
            updateLock.unlock();
        }
        return res;
    }

}
