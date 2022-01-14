package prvi.ssetglow.extenddatastructure.datastructure.tree.node;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.datastructure.tree.node
 * @className: TreeNode
 * @description:
 * @author: SsetGlow
 * @date: 2022-01-06 14:25
 **/
public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {

    private static final long serialVersionUID = 1L;

    protected final @NotNull T data;
    private TreeNode<T> parentNode;
    private final @NotNull ArrayList<TreeNode<T>> childNodes;

    public TreeNode(@NotNull T data) {
        this.data = data;
        this.childNodes = new ArrayList<>(0b10);
    }

    public TreeNode(@NotNull T data, TreeNode<T> parentNode) {
        this.data = data;
        this.parentNode = parentNode;
        this.childNodes = new ArrayList<>(0b10);
    }

    public @NotNull T getData() {
        return this.data;
    }

    public TreeNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public @NotNull ArrayList<TreeNode<T>> getChildNodes() {
        return this.childNodes;
    }

    public void addChildNode(@NotNull TreeNode<T> childNode) {
        for (int index = 0; index < this.childNodes.size(); ++index) {
            if (this.childNodes.get(index).compareTo(childNode) > 0) {
                this.childNodes.add(index, childNode);
                return;
            }
        }
        this.childNodes.add(childNode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(data, treeNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, parentNode);
    }

    @Override
    public int compareTo(@NotNull TreeNode<T> o) {
        return this.data.compareTo(o.getData());
    }
}
