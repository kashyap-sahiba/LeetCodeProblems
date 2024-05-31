import javafx.util.Pair;

public class _110_Balanced_Binary_Tree_ {

    private static Pair<Boolean,Integer> dfs(TreeNode node){

        if(node ==null){
            return new Pair<Boolean,Integer>(true,0);
        }

        var left = dfs(node.left);
        var right = dfs(node.right);

        var balanced = left.getKey() &&
                right.getKey() &&
                (Math.abs(left.getValue())- right.getValue()<=1);
        return new Pair<Boolean,Integer>(
                balanced,
                1+Math.max(left.getValue(),right.getValue())
        );
    }

    public static boolean isBalanced(TreeNode node) {
        return dfs(node).getKey();
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);

        boolean isBalanced = isBalanced(node);
        System.out.println("Is the binary tree balanced ? "+ isBalanced);

        TreeNode unbalancedNode = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.left.left= new TreeNode(5);

        boolean isBalanced1 = isBalanced(unbalancedNode);
        System.out.println("Is the binary tree balanced ? "+isBalanced1);


    }
}
