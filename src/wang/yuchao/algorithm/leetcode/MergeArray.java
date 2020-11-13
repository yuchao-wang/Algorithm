package wang.yuchao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wangyuchao
 * @date : 2020-11-04 16:13
 * Description : 数组构建新的数组
 * <p>
 * ["a", "b"]
 * ["c", "d", "e"]
 * ["f", "g", "h"]
 * ["i", "j", "k", "h"]
 * limit = 7
 * 输出
 * ["a","c","f","i","b","d","g"]
 */
public class MergeArray {

    public ArrayList<String> merge(ArrayList<ArrayList<String>> allList, int limit) {
        ArrayList<String> result = new ArrayList<>();

        if (limit <= 0) {
            return result;
        }

        while (result.size() < limit) {
            boolean isNotEmpty = false;
            for (int i = 0; i < allList.size(); i++) {
                List<String> itemList = allList.get(i);
                if (itemList != null && itemList.size() > 0) {
                    isNotEmpty = true;
                    if (result.size() < limit) {
                        result.add(itemList.get(0));
                        itemList.remove(0);
                    } else {
                        return result;
                    }
                }
            }
            if (!isNotEmpty) {
                return result;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 12; i++) {
            ArrayList<String> l1 = new ArrayList<>();
            l1.add("x1");
            l1.add("x2");
            l1.add("x3");
            ArrayList<String> l2 = new ArrayList<>();
            l2.add("y1");
            l2.add("y2");
            ArrayList<String> l3 = new ArrayList<>();
            l3.add("z1");
            l3.add("z2");
            l3.add("z3");
            l3.add("z4");

            ArrayList<ArrayList<String>> lists = new ArrayList<>();
            lists.add(l1);
            lists.add(l2);
            lists.add(l3);

            ArrayList<String> merge = new MergeArray().merge(lists, i);
            System.out.println(i + "===>" + merge.toString());
        }


    }
}
