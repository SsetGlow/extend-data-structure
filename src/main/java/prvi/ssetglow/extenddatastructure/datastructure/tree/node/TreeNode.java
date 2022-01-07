package prvi.ssetglow.extenddatastructure.datastructure.tree.node;

import java.util.Objects;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.datastructure.tree.node
 * @className: TreeNode
 * @description:
 * @author: SsetGlow
 * @date: 2022-01-06 14:25
 **/
public class TreeNode<T extends Comparable> {
    protected T data;
    private TreeNode<T> parentNode;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(data, treeNode.data) && Objects.equals(parentNode, treeNode.parentNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, parentNode);
    }
}
