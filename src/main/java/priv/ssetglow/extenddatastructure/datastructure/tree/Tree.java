package priv.ssetglow.extenddatastructure.datastructure.tree;

import org.jetbrains.annotations.NotNull;
import priv.ssetglow.extenddatastructure.datastructure.tree.node.TreeNode;

import java.io.Serial;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: SsetGlow
 * @since: 0.0.1
 * @date: 2022-01-06 14:21
 **/
public class Tree<T extends Comparable<T>> implements Serializable {

    @Serial
    private static final long serialVersionUID = 0b1L;

    protected @NotNull AtomicInteger size = new AtomicInteger();
    private TreeNode<T> root;

    private final ReentrantLock putLock = new ReentrantLock();
    private final ReentrantLock takeLock = new ReentrantLock();


    public void fullyLock() {
        this.putLock.lock();
        this.takeLock.lock();
    }

    public void fullyUnlock() {
        this.putLock.unlock();
        this.takeLock.unlock();
    }

    public Tree() {
        this.size.set(0b0);
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
        this.size.set(0b1);
    }

    public boolean isEmpty() {
        return null == this.root;
    }

    public int height(TreeNode<T> treeNode) {
        int height = 0;
        return height;
    }

    public int size() {
        return this.size.get();
    }

    public boolean insert(TreeNode<T> treeNode) {
        return this.root.addChildNode(treeNode);
    }

    public boolean remove(TreeNode<T> treeNode) {
        return false;
    }

    public boolean update(TreeNode<T> treeNode) {
        return false;
    }

}
