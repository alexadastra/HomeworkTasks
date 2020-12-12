package PrefixSearchTask;

import java.util.ArrayList;

public class SearchTree {
    private final TreeNode root;

    // according to the task, we use only Cyrillic or Latin alphabet
    // so we only need to define it's beginning and number of letters
    private final int k;
    private final char alphabetStart;

    // use Latin as default set
    public SearchTree(){
        k = 26;
        alphabetStart = 'a';
        root = new TreeNode(k);
    }

    public SearchTree(int k, char start){
        this.k = k;
        this.alphabetStart = start;
        root = new TreeNode(k);
    }

    public boolean isEmpty(){
        for (var node : root.children){
            if (node != null){
                return false;
            }
        }
        return true;
    }

    public void add(String value) throws IllegalArgumentException{
        if (value == null){
            throw new IllegalArgumentException("passed value is null");
        }
        TreeNode currentNode = root;
        // descent in tree, iterating through value and creating new nodes where needed
        for (char i : value.toCharArray()){
            // if passed string contains characters out of alphabet
            if (i < alphabetStart || i > alphabetStart + k){
                throw new IllegalArgumentException("inappropriate character in passed value");
            }
            if (currentNode.children[i - alphabetStart] == null){
                currentNode.children[i - alphabetStart] = new TreeNode(k, i);
            }
            currentNode = currentNode.children[i - alphabetStart];
        }
        // mark last node as the end of word
        currentNode.setAsEnd();
    }

    public ArrayList<String> searchWithPrefix(String prefix) throws IllegalArgumentException{
        // preprocess prefix in edge cases
        if (prefix == null){
            throw new IllegalArgumentException("passed prefix is null");
        }
        if (prefix.isBlank()){
            return new ArrayList<>();
        }
        TreeNode currentNode = root;
        // descent in tree with prefix to get searched words subtree
        for (char i : prefix.toCharArray()){
            // if passed prefix contains characters out of alphabet
            if (i < alphabetStart || i > alphabetStart + k){
                throw new IllegalArgumentException("inappropriate character in passed prefix");
            }
            // if the subtree doesn't exist, return empty array list
            if (currentNode.children[i - alphabetStart] == null){
                return new ArrayList<>();
            }
            currentNode = currentNode.children[i - alphabetStart];
        }
        // take arraylist as container as the complexity of element adding is O(1)
        // and searched words may be required to be ordered
        ArrayList<String> strings = new ArrayList<>();
        // redefine prefix to call recursive function
        prefix = prefix.substring(0, prefix.length() - 1);
        searchRecursively(currentNode, prefix, strings);

        return strings;
    }

    private void searchRecursively(TreeNode currentNode, String prefix, ArrayList<String> strings) {
        // if we get to empty node, go back to the previous one
        if (currentNode == null){
            return;
        }
        // if char is marked as end of the word, append word to the container
        if (currentNode.isEnd()){
            strings.add(prefix + currentNode.getValue());
        }

        for (var node : currentNode.children){
            searchRecursively(node, prefix + currentNode.getValue(), strings);
        }
    }
}
