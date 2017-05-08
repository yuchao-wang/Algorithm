package wang.yuchao.algorithm.tree;

import java.util.Stack;

/**
 * Created by wangyuchao on 17/4/27.
 */
public class BinaryTreeUtils {
    // 先序递归遍历（中序递归遍历和后序递归遍历类似）
    public static void preShow(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preShow(root.left);
            preShow(root.right);
        }
    }

    // 先序遍历（非递归）
    public static void preOrder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        BinaryTreeNode p = root;
        while (p != null || (!s.isEmpty())) {
            while (p != null) {
                System.out.print(p.data + " ");//访问
                s.push(p);
                p = p.left;
            }
            if (!s.isEmpty()) {
                p = s.pop();
                p = p.right;
            }
        }
    }

    // 中序遍历（非递归）
    public static void inOrder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        BinaryTreeNode p = root;
        while (p != null || (!s.isEmpty())) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            if (!s.isEmpty()) {
                p = s.pop();
                System.out.print(p.data + " ");//访问
                p = p.right;
            }
        }
    }

    // 后序遍历（非递归）
    public static void afterOrder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        BinaryTreeNode p = root;
        BinaryTreeNode q = p;
        while (p != null || (!s.isEmpty())) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            if (!s.isEmpty()) {
                p = s.pop();
                if (p.right == null || p.right == q) {
                    //如果没有右孩子或者右孩子已经被访问过则访问根节点
                    System.out.print(p.data + " ");
                    q = p;
                    p = null;
                } else {
                    //如果有右孩子并且右孩子没有被访问过
                    p = p.right;
                }
            }
        }
    }

    // 数组转成叶子节点
    public static BinaryTreeNode[] convertToBinaryTreeNode(int[] arrays) {
        int length = arrays.length;

        // 构造数据结构节点
        BinaryTreeNode[] allNodes = new BinaryTreeNode[length];
        for (int i = 0; i < length; i++) {
            BinaryTreeNode temp = new BinaryTreeNode(arrays[i]);
            allNodes[i] = temp;
        }

        return allNodes;
    }

    // 数组生成树，返回树根
    public static BinaryTreeNode createBinaryTreeFromArray(BinaryTreeNode[] allNodes) {
        int length = allNodes.length;

        // 构造树
        for (int i = 0; i < length / 2; i++) {
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            allNodes[i].left = allNodes[leftIndex];
            allNodes[i].right = allNodes[rightIndex];
        }

        return allNodes[0];
    }

    // 获取二叉树的深度
    public static int getDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
        }
    }

    // 获取子节点个数
    public static int getSubNodeNumber(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftNumber = getSubNodeNumber(root.left);
            int rightNumber = getSubNodeNumber(root.right);
            return leftNumber + rightNumber + 1;
        }
    }

    // 获取第k层的节点个数,index 当前层号(k和index从0开始)
    public static int getNumber(BinaryTreeNode root, int index, int k) {
        if (root == null) {
            return 0;
        } else {
            if (index == k) {
                return 1;
            } else if (index < k) {
                ++index;
                int leftNumber = getNumber(root.left, index, k);
                int rightNumber = getNumber(root.right, index, k);
                return leftNumber + rightNumber;
            } else {
                return 0;
            }
        }
    }

    // 得到一棵树的镜像
    public static BinaryTreeNode getMirror(BinaryTreeNode root) {
        if (root == null) {
            return null;
        } else {
            BinaryTreeNode left = getMirror(root.left);
            BinaryTreeNode right = getMirror(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }

    // 构建二叉排序树
    public static BinaryTreeNode createBinarySortTree(BinaryTreeNode[] allNodes) {
        if (allNodes != null) {
            int length = allNodes.length;
            for (int i = 1; i < length; i++) {
                insertBinarySortTree(allNodes[0], allNodes[i]);
            }
            return allNodes[0];
        }
        return null;
    }

    // 插入二叉排序树
    public static void insertBinarySortTree(BinaryTreeNode root, BinaryTreeNode node) {
        while (root != null) {
            if (node.data >= root.data) {
                if (root.right == null) {
                    root.right = node;
                    return;
                } else {
                    root = root.right;
                }
            } else {
                if (root.left == null) {
                    root.left = node;
                    return;
                } else {
                    root = root.left;
                }
            }
        }
    }

    // 删除二叉排序树上的某一个节点。(递归和循环都可以)
    // 1. 如果node是叶子节点，直接删除
    // 2. 如果node只有一个子树，则子树直接替换node节点
    // 3. 如果node有两个子树，可用左子树替换node节点，右子树放在左子树的最右边节点下。（同理可用右子树替换node节点，左子树放在右子树的最左边节点下）
    public static BinaryTreeNode deleteBinarySortTreeNode(BinaryTreeNode root, BinaryTreeNode node) {
        if (root != null && node != null) {

            BinaryTreeNode resultRoot = root;

            BinaryTreeNode fatherRoot = null;

            // 先查找某个节点
            while (root != null) {
                if (node.data > root.data) {
                    fatherRoot = root;
                    root = root.right;
                } else if (node.data < root.data) {
                    fatherRoot = root;
                    root = root.left;
                } else {
                    break;
                }
            }

            // fatherRoot为空说明是根节点

            // 如果找到了那个节点
            if (root != null) {
                if (root.left == null) {
                    if (root.right == null) {
                        // 左右子树都为null,删除这个节点
                        if (fatherRoot != null) {
                            if (node.data > fatherRoot.data) {
                                fatherRoot.right = null;
                            } else {
                                fatherRoot.left = null;
                            }
                            return resultRoot;
                        } else {
                            return null;
                        }

                    } else {
                        // 左子树为空,右子树不为空
                        if (fatherRoot != null) {
                            if (node.data > fatherRoot.data) {
                                fatherRoot.right = root.right;
                            } else {
                                fatherRoot.left = root.right;
                            }
                            return resultRoot;
                        } else {
                            return root.right;
                        }
                    }
                } else {
                    if (root.right == null) {
                        // 左子树不为空,右子树为空
                        if (fatherRoot != null) {
                            if (node.data > fatherRoot.data) {
                                fatherRoot.right = root.left;
                            } else {
                                fatherRoot.left = root.left;
                            }
                            return resultRoot;
                        } else {
                            return root.left;
                        }

                    } else {
                        // 右子树放置到左子树最大的右节点，或者
                        if (fatherRoot != null) {
                            if (node.data > fatherRoot.data) {
                                fatherRoot.right = root.left;
                            } else {
                                fatherRoot.left = root.left;
                            }
                            BinaryTreeNode currentRoot = root;
                            root = root.left;// 左子树
                            while (root.right != null) {
                                root = root.right;
                            }
                            root.right = currentRoot.right;
                            return resultRoot;
                        } else {
                            fatherRoot = root;
                            root = root.left;// 左子树
                            BinaryTreeNode newRoot = root;
                            while (root.right != null) {
                                root = root.right;
                            }
                            root.right = fatherRoot.right;
                            return newRoot;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int arrays[] = {0, 11, 22, 33, 44, 55, 66, 77, 88};
        BinaryTreeNode[] allNodes = convertToBinaryTreeNode(arrays);

        // 使用数组创建二叉树
        BinaryTreeNode root = createBinaryTreeFromArray(allNodes);

        // 子节点个数
        System.out.println("子节点个数：" + getSubNodeNumber(root));

        // 二叉树深度
        System.out.println("树的深度" + getDepth(root));

        // 先序遍历（递归）
        System.out.println("先序遍历（递归）");
        preShow(root);

        // 先序遍历（非递归）
        System.out.println("\n先序遍历（非递归）");
        preOrder(root);

        // 从上到下第k层的节点个数（k从0开始）
        System.out.println("\n第K层的节点个数为 " + getNumber(root, 0, 3));

        // 树的镜像
        System.out.println("树的镜像先序遍历 ");
        getMirror(root);
        preShow(root);

        // 二叉查找树
        System.out.println("\n构建二叉查找树");
        BinaryTreeNode[] allNodesBST = convertToBinaryTreeNode(new int[]{6, 3, 5, 2, 8, 9, 1, 7, 0, 4});
        BinaryTreeNode rootBST = createBinarySortTree(allNodesBST);

        System.out.println("中序遍历");
        inOrder(rootBST);

        System.out.println("\n删除某节点后，中序遍历");
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--------" + i);
            BinaryTreeNode temp = createBinarySortTree(convertToBinaryTreeNode(new int[]{6, 3, 5, 2, 8, 9, 1, 7, 0, 4}));
            BinaryTreeNode deleteRoot = deleteBinarySortTreeNode(temp, new BinaryTreeNode(i));
            inOrder(deleteRoot);
        }

    }
}
