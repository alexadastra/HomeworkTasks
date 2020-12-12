package PrefixSearchTask;

public class TreeNode {
    private char value;
    private boolean isEnd;
    TreeNode[] children;

    TreeNode(int k){
        value = ' ';
        isEnd = false;
        children = new TreeNode[k];
    }

    TreeNode(int k, char value){
        this(k);
        this.value = value;
    }

    public boolean isEnd(){
        return isEnd;
    }

    public void setAsEnd(){
        isEnd = true;
    }

    public char getValue(){
        return value;
    }
}
