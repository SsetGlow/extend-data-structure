package prvi.ssetglow.extenddatastructure.datastructure.tree;

import org.jetbrains.annotations.NotNull;
import prvi.ssetglow.extenddatastructure.datastructure.tree.node.TreeNode;

import java.util.ArrayList;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.datastructure.tree
 * @className: Tree
 * @description:
 * @author: SsetGlow
 * @date: 2022-01-06 14:21
 **/
public class Tree<T extends Comparable<T>> {
    protected @NotNull Integer size;
    private TreeNode<T> root;
    private final ArrayList<TreeNode<T>> nodes;

    public Tree() {
        this.nodes = new ArrayList<>();
        this.size = 0b0;
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
        this.nodes = new ArrayList<>(0b100);
        this.size = 0b1;
        this.nodes.add(root);
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
        this.nodes.forEach(node -> {
            if (node.getData().compareTo(treeNode.getData()) < 0) {

            }
        });
        return false;
    }

    public boolean remove(TreeNode<T> treeNode) {
        return false;
    }

    public boolean update(TreeNode<T> treeNode) {
        return false;
    }

}
