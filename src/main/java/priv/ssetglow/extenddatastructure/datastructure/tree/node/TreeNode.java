package priv.ssetglow.extenddatastructure.datastructure.tree.node;

import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author SsetGlow
 * @since 0.1
 * @date 2022-01-06 14:25
 **/
public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
        return this.parentNode;
    }

    public void setParentNode(TreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public @NotNull ArrayList<TreeNode<T>> getChildNodes() {
        return this.childNodes;
    }

    public boolean addChildNode(@NotNull TreeNode<T> node) {
        return childNodes.add(node);
    }

    public boolean addChildNode(@NotNull TreeNode<T> node, int index) {
        return childNodes.add(node);
    }

    public boolean removeChildNode(@NotNull TreeNode<T> node) {
        return childNodes.remove(node);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        TreeNode<?> treeNode = (TreeNode<?>) other;
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
