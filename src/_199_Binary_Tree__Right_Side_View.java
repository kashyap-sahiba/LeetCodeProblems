import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_Binary_Tree__Right_Side_View {

    public static List<Integer> rightSideView(TreeNode root){

        List<Integer> res = new ArrayList();
        Queue<TreeNode> q = new LinkedList();

        if(root == null){
            return res;
        }

        q.offer(root);

        while(!q.isEmpty()){

            int qSize = q.size();

            for(int i=0;i<qSize;i++){

                TreeNode curr = q.poll();

                if(i==qSize-1){
                    res.add(curr.val);
                }

                if(curr.left!=null)
                    q.offer(curr.left);

                if(curr.right!=null)
                    q.offer(curr.right);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(4);

        List<Integer> res = rightSideView(node);

        System.out.println(res);
    }
}
