package grayCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if (n == 0) {
            return res;
        }
        for (int i = 0; i < n; i++) {
            int len = res.size();
            for (int j = len - 1; j >= 0; j--) {
                int add = (int) Math.pow(2, i);
                res.add(res.get(j) + add);
            }
        }

        return res;
    }

}
