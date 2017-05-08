package wang.yuchao.algorithm.tree;

/**
 * Created by wangyuchao on 17/5/4.
 */

// T 是可比较的节点数据对象
public class RedBlackTreeNode<T extends Comparable<T>> {

    public T data;

    public RedBlackTreeNode<T> left;

    public RedBlackTreeNode<T> right;

    public RedBlackTreeNode<T> parent;

    public boolean isRed;

}
