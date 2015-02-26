package simplifyPath;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] paths = path.split("/");
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals(".") || paths[i].equals("")) {
                continue;
            } else if (paths[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(paths[i]);
            }
        }
        if (stack.isEmpty())
            return "/";
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            String p = stack.pop();
            sb.insert(0, "/" + p);
        }
        return sb.toString();
    }
}
