public class _98_Valid_Binary_Search_Tree {

    private static boolean valid(TreeNode root , double left , double right){
        if(root == null)
            return true;

        if(!(left<root.val && root.val<right))
            return false;

        return valid(root.left,left,root.val) && valid(root.right, root.val, right);
    }

    public static boolean isValidBST(TreeNode node){
        return valid(node,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        if(isValidBST(node)){
            System.out.println("Test case passed !!");
        }else {
            System.out.println("Failed!");
        }
    }
}
