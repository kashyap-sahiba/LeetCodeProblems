import java.util.*;

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder){

        if(preorder.length == 0 || inorder.length == 0)
            return null;

        TreeNode node = new TreeNode(preorder[0]);
        int mid = 0;

        for(int i=0; i< inorder.length; i++)
            if(preorder[0] == inorder[i])
                mid = i;

        node.left = buildTree(
                Arrays.copyOfRange(preorder, 1 , mid+1),
                Arrays.copyOfRange(inorder, 0,mid+1)
        );

        node.right = buildTree(
                Arrays.copyOfRange(preorder,mid+1,preorder.length),
                Arrays.copyOfRange(inorder,mid+1,inorder.length)
        );

        return node;
    }

    public static void main(String[] args) {
        int[] preoder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        int[] expected = new int[]{3,9,20,15,7};

        TreeNode node = buildTree(preoder,inorder);
        int[] result = new int[preoder.length];
        if(node == null){
            result = new int[0];
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            list.add(treeNode.val);

            if(treeNode.left!=null)
                queue.add(treeNode.left);

            if(treeNode.right!=null)
                queue.add(treeNode.right);
        }

        for(int i =0; i<list.size();i++){
            result[i] = list.get(i);
        }

    if(Arrays.equals(result,expected)){
        System.out.println("Test Case Passed");
    }else{
        System.out.println("Failed!");
    }
    }
}
