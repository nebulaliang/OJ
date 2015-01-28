package pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }

        List<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        int level = 1;
        result.add(new ArrayList<Integer>(cur));
        while (level < numRows) {
            List<Integer> newList = new ArrayList<Integer>();
            int last = 0;
            for (Integer num : cur) {
                newList.add(last + num);
                last = num;
            }
            newList.add(1);
            result.add(newList);
            cur = newList;
            level++;
        }

        return result;
    }

    public List<Integer> getRow(int rowIndex) {

        List<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        int level = 0;
        while (level < rowIndex) {
            List<Integer> newList = new ArrayList<Integer>();
            int last = 0;
            for (Integer num : cur) {
                newList.add(last + num);
                last = num;
            }
            newList.add(1);
            cur = newList;
            level++;
        }

        return cur;
    }
}
