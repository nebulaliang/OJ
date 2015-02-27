package triangle;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }

        int rows = triangle.size();
        List<Integer> last = new ArrayList<Integer>();
        last.add(triangle.get(0).get(0));
        for (int i = 1; i < rows; i++) {
            List<Integer> temp_row = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    temp_row.add(last.get(0) + triangle.get(i).get(0));
                } else if (j == i) {
                    temp_row.add(last.get(i - 1) + triangle.get(i).get(i));
                } else {
                    temp_row.add(Math.min(last.get(j - 1), last.get(j))
                            + triangle.get(i).get(j));
                }
            }

            last = temp_row;
        }

        int result = last.get(0);
        for (int value : last) {
            result = Math.min(result, value);
        }

        return result;
    }
}
