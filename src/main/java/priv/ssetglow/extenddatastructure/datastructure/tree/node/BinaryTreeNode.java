package priv.ssetglow.extenddatastructure.datastructure.tree.node;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author SsetGlow
 * @date 2022-03-18 周五 14:52
 * @since 1.0.0
 **/
public class BinaryTreeNode<T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>> {

    final private T element;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(@NotNull T element) {
        this.element = element;
    }

    public BinaryTreeNode(T element, @Nullable BinaryTreeNode<T> leftChild, @Nullable BinaryTreeNode<T> rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
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

    public void setBoth(@Nullable BinaryTreeNode<T> leftChild, @Nullable BinaryTreeNode<T> rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<T> setLeftChild(BinaryTreeNode<T> node) {
        this.leftChild = node;
        return this.leftChild;
    }

    public BinaryTreeNode<T> setRightChild(BinaryTreeNode<T> node) {
        this.rightChild = node;
        return this.rightChild;
    }

    public boolean isLeaf() {
        return hasNoChild();
    }

    public boolean onlyHasRightChild() {
        return null != leftChild && null == rightChild;
    }

    public boolean onlyHasLeftChild() {
        return null != leftChild && null == rightChild;
    }

    public boolean hasNoChild() {
        return null == leftChild && null == rightChild;
    }

    public boolean hasBothChild() {
        return null != leftChild && null != rightChild;
    }

    @Override
    public int compareTo(@NotNull BinaryTreeNode<T> o) {
        return this.element.compareTo(o.getElement());
    }
}
