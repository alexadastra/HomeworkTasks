package PrefixSearchTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PrefixTreeAddTest {
    @Test
    public void EmptyTree(){
        SearchTree tree = new SearchTree();

        Assertions.assertTrue(tree.isEmpty());
    }

    @Test
    public void AddRoot(){
        SearchTree tree = new SearchTree();
        tree.add("hello");

        Assertions.assertFalse(tree.isEmpty());
    }

    @Test
    public void AddEmptyString(){
        SearchTree tree = new SearchTree();
        tree.add("");

        Assertions.assertTrue(tree.isEmpty());
    }

    @Test
    public void AddNull(){
        SearchTree tree = new SearchTree();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> tree.add(null));

        String expected = "passed value is null";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void AddIllegalValue(){
        SearchTree tree = new SearchTree();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> tree.add("3465365"));

        String expected = "inappropriate character in passed value";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }
}
