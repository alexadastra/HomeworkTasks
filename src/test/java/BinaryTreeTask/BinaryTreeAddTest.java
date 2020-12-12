package BinaryTreeTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeAddTest {
    @Test
    public void EmptyTree(){
        BinaryTree tree = new BinaryTree();

        Assertions.assertTrue(tree.isEmpty());
    }

    @Test
    public void AddRoot(){
        BinaryTree tree = new BinaryTree();
        tree.add(0);

        Assertions.assertFalse(tree.isEmpty());
        Assertions.assertEquals(0, tree.getRootValue());
    }

    @Test
    public void RootIsNotChangeable(){
        BinaryTree tree = new BinaryTree();
        tree.add(0);
        tree.add(1);
        tree.add(-1);
        Assertions.assertEquals(0, tree.getRootValue());
    }
}