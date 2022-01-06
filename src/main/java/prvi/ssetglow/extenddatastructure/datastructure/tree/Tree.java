package prvi.ssetglow.extenddatastructure.datastructure.tree;

import prvi.ssetglow.extenddatastructure.datastructure.tree.node.TreeNode;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.datastructure.tree
 * @className: Tree
 * @description:
 * @author: SsetGlow
 * @date: 2022-01-06 14:21
 **/
public class Tree {
    protected TreeNode root;

    public Tree() {
    }

    public Tree(TreeNode root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return null == root;
    }

    public boolean insert(TreeNode treeNode) {
        return false;
    }

    public boolean remove(TreeNode treeNode) {
        return false;
    }

    public boolean update(TreeNode treeNode) {
        return false;
    }

    public TreeNode search() {
        return root;
    }

}
