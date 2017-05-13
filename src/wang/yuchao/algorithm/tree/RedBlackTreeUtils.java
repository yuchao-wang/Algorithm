package wang.yuchao.algorithm.tree;

import java.util.TreeMap;

/**
 * Created by wangyuchao on 17/5/4.
 */
public class RedBlackTreeUtils {

    public int data;
    public RedBlackTreeUtils son;
    public RedBlackTreeUtils parent;

    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        int[] arrays = {3, 2, 4, 5, 6, 7, 1, 8};
        for (int i = 0; i < arrays.length; i++) {
            tree.insert(arrays[i]);
        }
        System.out.println(tree.toString());
    }
}
