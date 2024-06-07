import java.util.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _102_Binary_Tree_Level_Order_Traversal {

    public static List<List<Integer>> levelOrder(TreeNode root){

        List<List<Integer>> res = new ArrayList<>();

        if(root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new LinkedList<>();

            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                level.add(curr.val);

                if(curr.left!=null){
                    q.add(curr.left);
                }

                if(curr.right!=null){
                    q.add(curr.right);
                }
            }

            res.add(level);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right= new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right=new TreeNode(7);

        List<List<Integer>> result = levelOrder(node);
        System.out.println(result);
    }
}
