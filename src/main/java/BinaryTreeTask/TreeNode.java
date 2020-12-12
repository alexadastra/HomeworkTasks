package BinaryTreeTask;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    TreeNode(){
        value = 0;
        left = right = null;
    }

    TreeNode(int value){
        this();
        this.value = value;
    }

    int getValue(){
        return value;
    }

    TreeNode getLeft(){
        return left;
    }

    TreeNode getRight(){
        return right;
    }

    void setLeft(TreeNode left){
        this.left = left;
    }

    void setRight(TreeNode right){
        this.right = right;
    }
}
