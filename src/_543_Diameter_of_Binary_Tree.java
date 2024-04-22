public class _543_Diameter_of_Binary_Tree {

    static int result = -1;
    public static int diameterOfBinaryTree(TreeNode root){
        dfs(root);
        return result;
    }

    public static int dfs(TreeNode node){
        if(node==null){
            return -1;
        }

        int left=1+dfs(node.left);
        int right = 1+dfs(node.right);

        result=Math.max(result,left+right);

        return Math.max(left,right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right=new TreeNode(5);

        System.out.println("Diameter of he tree "+ diameterOfBinaryTree(root));
    }
}
