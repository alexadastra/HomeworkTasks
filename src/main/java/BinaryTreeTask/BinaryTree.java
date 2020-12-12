package BinaryTreeTask;

public class BinaryTree {
    private TreeNode root;

    public boolean isEmpty() { return root == null; }

    public int getRootValue(){
        return root.getValue();
    }

    public void add(int value){
        root = addRecursively(root, value);
    }

    public boolean contains(int value){
        return containsRecursively(root, value);
    }

    public int calculateDiameter(){ return calculateDiameterRecursively(root, new Height()); }

    private TreeNode addRecursively(TreeNode currentNode, int value){
        // if function gets to the leaf, create new node
        if(currentNode == null){
            return new TreeNode(value);
        }
        // if value less than current, go to the left branch; if greater, to the right one
        if (value < currentNode.getValue()){
            currentNode.setLeft(addRecursively(currentNode.getLeft(), value));
        }
        else if (value > currentNode.getValue()){
            currentNode.setRight(addRecursively(currentNode.getRight(), value));
        }
        // otherwise the tree already has the node
        else{
            return currentNode;
        }
        return currentNode;
    }

    private boolean containsRecursively(TreeNode currentNode, int value){
        if (currentNode == null) {
            return false;
        }
        if (value == currentNode.getValue()){
            return true;
        }
        if (value < currentNode.getValue()){
            return containsRecursively(currentNode.getLeft(), value);
        }
        return  containsRecursively(currentNode.getRight(), value);
    }

    private int calculateDiameterRecursively(TreeNode currentNode, Height height){
        // to avoid calculating heights for every subtree, store values as objects
        // and change them as we go up the tree
        // this decreases time complexity to O(nodes_number)
        Height leftHeight = new Height(), rightHeight = new Height();

        if (currentNode == null){
            height.value = 0;
            return 0;
        }

        int leftDiameter = calculateDiameterRecursively(currentNode.getLeft(), leftHeight);
        int rightDiameter = calculateDiameterRecursively(currentNode.getRight(), rightHeight);

        height.value = Math.max(leftHeight.value, rightHeight.value) + 1;
        return Math.max(leftHeight.value + rightHeight.value + 1, Math.max(leftDiameter, rightDiameter));
    }

    private static class Height{
        int value;
    }
}
