public class _124_Binary_Tree_Maximum_Path_Sum {

    public static int maxPathSum(TreeNode node){
        int[] res = {Integer.MIN_VALUE};
        maxPathSum(node, res);
        return res[0];
    }

    public static int maxPathSum(TreeNode node, int[] res){
        if(node==null) return 0;

        int left = Math.max(0, maxPathSum(node.left, res));
        int right = Math.max(0, maxPathSum(node.right, res));
        res[0] = Math.max(res[0], node.val+left+right);

        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        int answer = 42;
        int result = maxPathSum(node);
        if(answer == result)
            System.out.println("Test Case Passed");
        else
            System.out.println("Failed");

        System.out.println(result);
    }
}
