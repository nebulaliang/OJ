package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] num) {
        int n = num.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < 3) {
            return result;
        }
        Arrays.sort(num);
        int last1 = num[0] - 1;
        List<Integer> last = new ArrayList<Integer>();
        for (int i = 0; i <= n - 3; i++) {
            int val = num[i];
            if (val == last1) {
                continue;
            }
            int target = -val;
            int j = i + 1;
            int k = n - 1;
            int last2 = num[0] - 1;
            int last3 = num[0] - 1;
            while (j < k) {
                int sum = num[j] + num[k];
                if (sum == target) {
                    if (last2 == num[j]) {
                        j++;
                        continue;
                    }
                    if (last3 == num[k]) {
                        k--;
                        continue;
                    }
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(val);
                    list.add(num[j]);
                    list.add(num[k]);
                    result.add(list);
                    last1 = val;
                    last2 = num[j];
                    last3 = num[k];
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

}
