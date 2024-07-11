import java.util.ArrayList;
import java.util.List;

public class _230_Kth_Smallest_Element_in_a_BST {

    public static int kthSmallest(TreeNode node, int k){
        List<Integer> list = new ArrayList();
        inorder(node, list);
        return  list.get(k-1);

    }

    public static void inorder(TreeNode node, List<Integer> list){
        if(node == null) return;

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        int kthSmallest = kthSmallest(root, 1);

        if(kthSmallest == 1){
            System.out.println("Test Case Passed");
        }else {
            System.out.println("Failed");
        }

    }
}
