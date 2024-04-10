class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val=x;
    }
}
public class _226_Invert_Binary_Tree_ {
    public static TreeNode invertTree(TreeNode node){
        if(node == null){
            return null;
        }

        //Swap left and right subtrees;
        TreeNode temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(9);

        TreeNode invertedTree = invertTree(root);


    }
}
