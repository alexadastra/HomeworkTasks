package BinaryTreeTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeDiameterTest {
    @Test
    public void StandardTree(){
        BinaryTree tree = new BinaryTree();
        tree.add(0);
        tree.add(-2);
        tree.add(-3);
        tree.add(-1);
        tree.add(3);

        Assertions.assertEquals(4, tree.calculateDiameter());
    }

    @Test
    public void EmptyTree(){
        BinaryTree tree = new BinaryTree();

        Assertions.assertEquals(0, tree.calculateDiameter());
    }

    @Test
    public void RootTree(){
        BinaryTree tree = new BinaryTree();
        tree.add(0);

        Assertions.assertEquals(1, tree.calculateDiameter());
    }


    @Test
    public void ChainTree(){
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);

        Assertions.assertEquals(5, tree.calculateDiameter());
    }

    @Test
    public void SemiChainTree(){
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(-1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);

        Assertions.assertEquals(6, tree.calculateDiameter());
    }
}
