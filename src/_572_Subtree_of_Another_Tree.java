import javax.swing.tree.TreeCellRenderer;

public class _572_Subtree_of_Another_Tree {

    public static boolean isSubTree(TreeNode root, TreeNode subRoot){
        if(subRoot == null){
            return true;
        }

        if(root == null){
            return false;
        }

        if(isSameTree(root,subRoot)){
            return true;
        }

        return isSubTree(root.left,subRoot) || isSubTree(root.right,subRoot);

    }

    public static boolean isSameTree(TreeNode root , TreeNode subRoot){

        if(root == null && subRoot == null){
            return true;
        }

        if(root == null || subRoot == null){
            return false;
        }

        if(root.val!=subRoot.val){
            return false;
        }

        return isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left =new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(isSubTree(root,subRoot));
    }
}
