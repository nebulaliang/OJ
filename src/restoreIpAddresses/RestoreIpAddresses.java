package restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        List<String> temp = new ArrayList<String>();
        dfs(result, temp, 0, s);
        return result;
    }

    private boolean isValid(String str) {
        if (str.charAt(0) == '0') {
            return str.equals("0");
        }
        int digit = Integer.valueOf(str);
        return digit > 0 && digit <= 255;
    }

    private String list2IP(List<String> list) {
        StringBuffer ip = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            ip.append(list.get(i));
            if (i != list.size() - 1) {
                ip.append(".");
            }
        }
        return new String(ip);
    }

    private void dfs(List<String> result, List<String> temp, int start, String s) {
        if (temp.size() == 4) {
            if (start != s.length()) {
                return;
            }
            result.add(list2IP(temp));
            return;
        }

        for (int i = start; i < s.length() && i <= start + 3; i++) {
            String split = s.substring(start, i + 1);
            if (isValid(split)) {
                temp.add(split);
                dfs(result, temp, i + 1, s);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
