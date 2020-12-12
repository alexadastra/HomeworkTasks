package PrefixSearchTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class PrefixTreeSearchTest {
    SearchTree mockTree(){
        SearchTree tree = new SearchTree();

        tree.add("ma");
        tree.add("mama");
        tree.add("machine");
        tree.add("meat");
        tree.add("meatball");

        return tree;
    }

    @Test
    public void DefaultCase(){
        SearchTree tree = mockTree();

        HashSet<String> expected = new HashSet<>(Arrays.asList("ma", "mama", "machine"));
        Assertions.assertEquals(expected, new HashSet<>(tree.searchWithPrefix("ma")));
    }

    @Test
    public void ReturnsEmptyList(){
        SearchTree tree = mockTree();

        HashSet<String> expected = new HashSet<>(Collections.emptyList());
        Assertions.assertEquals(expected, new HashSet<>(tree.searchWithPrefix("hello")));
    }

    @Test
    public void SearchByEmptyPrefix(){
        SearchTree tree = mockTree();

        HashSet<String> expected = new HashSet<>(Collections.emptyList());
        Assertions.assertEquals(expected, new HashSet<>(tree.searchWithPrefix("")));
    }

    @Test
    public void SearchByNull(){
        SearchTree tree = new SearchTree();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> tree.searchWithPrefix(null));

        String expected = "passed prefix is null";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SearchByIllegalPrefix(){
        SearchTree tree = mockTree();

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                tree.searchWithPrefix("m0ch"));

        String expected = "inappropriate character in passed prefix";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }
}
