package priv.ssetglow.extenddatastructure.datastructure.tree.node;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @program: extend-data-structure
 * @package: priv.ssetglow.extenddatastructure.datastructure.tree.node
 * @class: TreeNode
 * @description:
 * @author: SsetGlow
 * @date: 2022-01-06 14:25
 **/
public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {

    private static final long serialVersionUID = 0b1L;

    protected final @NotNull T element;
    private TreeNode<T> parentNode;
    private final @NotNull ArrayList<TreeNode<T>> childNodes;

    public TreeNode(@NotNull T element) {
        this.element = element;
        this.childNodes = new ArrayList<>(0b10);
    }

    public TreeNode(@NotNull T data, TreeNode<T> parentNode) {
        this.element = data;
        this.parentNode = parentNode;
        this.childNodes = new ArrayList<>(0b10);
    }

    public @NotNull T getElement() {
        return this.element;
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

    public boolean addChildNode(@NotNull TreeNode<T> childNode) {
        return false;
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
        return Objects.equals(element, treeNode.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, parentNode);
    }

    @Override
    public int compareTo(@NotNull TreeNode<T> o) {
        return this.element.compareTo(o.getElement());
    }
}
