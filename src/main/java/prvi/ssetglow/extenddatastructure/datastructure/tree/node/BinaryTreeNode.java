package prvi.ssetglow.extenddatastructure.datastructure.tree.node;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.datastructure.tree.node
 * @className: BinaryTreeNode
 * @description:
 * @author: SsetGlow
 * @date: 2022-01-06 14:24
 **/
public class BinaryTreeNode extends TreeNode {
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
