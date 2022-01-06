package prvi.ssetglow.extenddatastructure.datastructure.tree.node;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.datastructure.tree.node
 * @className: TreeNode
 * @description:
 * @author: SsetGlow
 * @date: 2022-01-06 14:25
 **/
public class TreeNode<T> {
    protected T data;
    protected TreeNode<T> parentNode;
    protected TreeNode<T> childNode;

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

    public TreeNode<T> getChildNode() {
        return childNode;
    }

    public void setChildNode(TreeNode<T> childNode) {
        this.childNode = childNode;
    }
}
