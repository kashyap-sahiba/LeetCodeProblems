public class _1448_Count_Good_Nodes_in_Binary_Tree {

    public static int goodNodes(TreeNode node){
        return helper(node,-99999);
    }

    public static int helper(TreeNode node, int max){
        if(node == null){
            return 0;
        }

        int res = node.val > max ? 1 : 0;

        res+= helper(node.left,Math.max(max,node.val));
        res+= helper(node.right,Math.max(max,node.val));

        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);

        node.left = new TreeNode(1);
        node.left.left = new TreeNode(3);

        node.right = new TreeNode(4);
        node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(5);

        System.out.println(goodNodes(node));
    }
}
