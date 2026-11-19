/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str=new StringBuilder();
        pre(root,str);
        return str.toString();
    }
    public void pre(TreeNode root,StringBuilder str){
    if(root==null){
    str.append("null,");
    return;
    }
    str.append(root.val).append(",");
    pre(root.left,str);
    pre(root.right,str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q=new LinkedList<>(Arrays.asList(data.split(",")));
        return build(q);
    }
    public TreeNode build(Queue<String> q){
        String s=q.poll();
        if(s.equals("null")){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(s));
        root.left=build(q);
        root.right=build(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));