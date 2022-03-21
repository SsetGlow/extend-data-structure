package priv.ssetglow.extenddatastructure.datastructure.tree.node;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author: SsetGlow
 * @since: 1.0.0
 * @date: 2022-03-18 周五 14:52
 **/
public class BinaryTreeNode<T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>> {

    private T element;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(@NotNull T element) {
        this.element = element;
    }

    public @NotNull T getElement() {
        return element;
    }

    @Nullable
    public BinaryTreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    @Nullable
    public BinaryTreeNode<T> getRightChild() {
        return this.rightChild;
    }

    public BinaryTreeNode<T> setLeftChild(BinaryTreeNode<T> node) {
        this.leftChild = node;
        return this.leftChild;
    }
    
    public BinaryTreeNode<T> setRightChild(BinaryTreeNode<T> node) {
        this.rightChild = node;
        return this.rightChild;
    }

    @Override
    public int compareTo(@NotNull BinaryTreeNode<T> o) {
        return this.element.compareTo(o.getElement());
    }
}
