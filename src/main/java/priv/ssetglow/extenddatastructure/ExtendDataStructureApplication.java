package priv.ssetglow.extenddatastructure;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import priv.ssetglow.extenddatastructure.datastructure.tree.BinaryTree;
import priv.ssetglow.extenddatastructure.datastructure.tree.node.BinaryTreeNode;

/**
 * @author: SsetGlow
 * @since: 0.1
 * @create 2021-11-10 19:46
 */
@SpringBootApplication
public class ExtendDataStructureApplication {

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        int[] datas = {5, 3, 7, 6, 8, 4, 2, 1, 9};
        for (Integer i : datas) {
            binaryTree.insert(new BinaryTreeNode<>(i));
        }
        BinaryTreeNode<Integer> node = binaryTree.find(new BinaryTreeNode<>(3));
        System.out.println(node);
    }

}
