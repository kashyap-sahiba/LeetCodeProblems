import java.util.ArrayList;
import java.util.List;

public class _297SerializeAndDeserializeBinaryTree {

    public static String serialize(TreeNode node){

        List<String> res = new ArrayList<>();
        dfsSerialize(node,res);

        return String.join(",",res);
    }

    public static void dfsSerialize(TreeNode node, List<String> res){
        if(node == null){
            res.add("N");
            return;
        }

        res.add(String.valueOf(node.val));
        dfsSerialize(node.left,res);
        dfsSerialize(node.right,res);
    }

    public static TreeNode deserialize(String data){
        String[] vals = data.split(",");
        int[] i = {0};

        return dfsDeserialize(vals,i);
    }

    public static TreeNode dfsDeserialize(String[] vals, int[] i){
        if(vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfsDeserialize(vals,i);
        node.right = dfsDeserialize(vals, i);

        return node;
    }
}
