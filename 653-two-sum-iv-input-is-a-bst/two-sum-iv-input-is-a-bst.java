class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();

        pushLeft(root,s1);
        pushRight(root,s2);
        TreeNode left = getNext(s1);
        TreeNode right = getBefore(s2);

        while(left!=right &&left.val<right.val){
            int sum = left.val + right.val;
            if(sum==k) return true;
            else if(sum>k){
                right=getBefore(s2);
            }
            else{
                left=getNext(s1);
            }
        }
        return false;
    }

    public void pushLeft(TreeNode node, Stack<TreeNode> st) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public void pushRight(TreeNode node, Stack<TreeNode> st) {
        while (node != null) {
            st.push(node);
            node = node.right;
        }
    }

    public TreeNode getNext(Stack<TreeNode> st) {
        TreeNode node = st.pop();
        pushLeft(node.right, st);
        return node;
    }

    public TreeNode getBefore(Stack<TreeNode> st) {
        TreeNode node = st.pop();
        pushRight(node.left, st);
        return node;
    }

}