package wang.yuchao.algorithm.tree;

import java.util.HashMap;

/**
 * Created by wangyuchao on 17/4/27.
 */
public class TreeDemo {

    /**
     * @param root
     */
    public static void preOrder(BinaryTree root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * @param arrays
     * @return 数组生成树，返回树根
     */
    public static BinaryTree arrayToBinaryTree(int[] arrays) {
        int length = arrays.length;

        // 构造数据结构节点
        BinaryTree[] allNodes = new BinaryTree[length];
        for (int i = 0; i < length; i++) {
            BinaryTree temp = new BinaryTree();
            temp.data = arrays[i];
            allNodes[i] = temp;
        }

        // 构造树
        for (int i = 0; i < length / 2; i++) {
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            allNodes[i].left = allNodes[leftIndex];
            allNodes[i].right = allNodes[rightIndex];
        }

        return allNodes[0];
    }

    public static void main(String[] args) {
        int arrays[] = {0, 11, 22, 33, 44, 55, 66, 77, 88};
        BinaryTree root = arrayToBinaryTree(arrays);
        preOrder(root);
    }
}
