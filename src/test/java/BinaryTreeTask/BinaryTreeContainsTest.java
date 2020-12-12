package BinaryTreeTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeContainsTest {
    @Test
    public void emptyTree(){
        BinaryTree tree = new BinaryTree();
        Assertions.assertFalse(tree.contains(0));
    }

    @Test
    public void treeWithValues(){
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(-2);
        tree.add(2);
        tree.add(3);

        Assertions.assertTrue(tree.contains(1));
        Assertions.assertTrue(tree.contains(-2));
        Assertions.assertFalse(tree.contains(10));
    }
}
