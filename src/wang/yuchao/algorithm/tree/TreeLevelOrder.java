package wang.yuchao.algorithm.tree;

import java.util.ArrayList;

/**
 * @author : wangyuchao
 * @date : 2020-11-11 11:56
 * Description : 树的层序遍历
 */
public class TreeLevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public ArrayList<ArrayList<TreeNode>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 结果
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<>();

        // 队列
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<TreeNode> levelQueue = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.get(i);
                levelQueue.add(treeNode);

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

                queue.remove(0);
            }

            result.add(levelQueue);
        }

        return result;
    }

}
