class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode target = null;
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.val == start) {
                target = curr;
            }
            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean infected = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                    infected = true;
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                    infected = true;
                }
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    q.offer(parent.get(curr));
                    visited.add(parent.get(curr));
                    infected = true;
                }
            }
            if (infected) {
                time++;
            }
        }
        return time;
    }
}