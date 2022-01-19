package priv.ssetglow.extenddatastructure.datastructure.tree;

import org.jetbrains.annotations.NotNull;
import priv.ssetglow.extenddatastructure.datastructure.tree.node.TreeNode;

/**
 * @author: SsetGlow
 * @since: 0.0.1
 * @date: 2022-01-06 14:21
 **/
public class Tree<T extends Comparable<T>> {
    protected @NotNull Integer size;
    private TreeNode<T> root;

    public Tree() {
        this.size = 0b0;
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
        this.size = 0b1;
    }

    public boolean isEmpty() {
        return null == this.root;
    }

    public int height(TreeNode<T> treeNode) {
        int height = 0;
        return height;
    }

    public int size() {
        return this.size;
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
