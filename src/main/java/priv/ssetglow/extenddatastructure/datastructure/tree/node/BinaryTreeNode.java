package priv.ssetglow.extenddatastructure.datastructure.tree.node;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author: SsetGlow
 * @since: 1.0.0
 * @date: 2022-03-18 周五 14:52
 **/
public class BinaryTreeNode<T extends Comparable<T>> extends TreeNode<T> {

    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(@NotNull T element) {
        super(element);
    }

    @Override
    public @NotNull T getElement() {
        return super.getElement();
    }

    @Nullable
    public BinaryTreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    @Nullable
    public BinaryTreeNode<T> getRightChild() {
        return this.rightChild;
    }

    @NotNull
    public BinaryTreeNode<T> setLeftChild(@NotNull BinaryTreeNode<T> node) {
        this.leftChild = node;
        return this.leftChild;
    }

    @NotNull
    public BinaryTreeNode<T> setRightChild(@NotNull BinaryTreeNode<T> node) {
        this.rightChild = node;
        return this.rightChild;
    }

}
