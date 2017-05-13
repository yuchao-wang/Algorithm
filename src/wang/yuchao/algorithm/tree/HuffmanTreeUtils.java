package wang.yuchao.algorithm.tree;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;

/**
 * Created by wangyuchao on 17/5/5.
 */
public class HuffmanTreeUtils {

    public static HuffmanTreeNode createHuffmanTree(LinkedList<HuffmanTreeNode> root) {
        while (root.size() > 1) {

            // 找到最小
            HuffmanTreeNode min = getMin(root);
            root.remove(min);

            // 找到最小
            HuffmanTreeNode minSec = getMin(root);
            root.remove(minSec);

            // 生成父节点并添加
            HuffmanTreeNode parentNode = new HuffmanTreeNode(min.weight + minSec.weight);
            parentNode.left = min;
            parentNode.right = minSec;
            root.add(parentNode);
        }

        return root.getFirst();
    }

    public static HuffmanTreeNode getMin(LinkedList<HuffmanTreeNode> root) {
        HuffmanTreeNode min = root.getFirst();
        for (HuffmanTreeNode currentNode : root) {
            if (currentNode.weight < min.weight) {
                min = currentNode;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int allWeights[] = {3, 2, 4, 5, 6, 7, 1, 8};

        LinkedList<HuffmanTreeNode> linkedList = new LinkedList<HuffmanTreeNode>();
        int length = allWeights.length;
        for (int i = 0; i < length; i++) {
            HuffmanTreeNode node = new HuffmanTreeNode(allWeights[i]);
            linkedList.add(node);
        }

        HuffmanTreeNode root = createHuffmanTree(linkedList);

        System.out.println("构建哈夫曼树成功");

    }
}
