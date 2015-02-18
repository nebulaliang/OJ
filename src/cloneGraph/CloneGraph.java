package cloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        int start = 0;
        // copy nodes
        while (start < nodes.size()) {
            UndirectedGraphNode tempNode = nodes.get(start++);
            for (UndirectedGraphNode neighbor : tempNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    nodes.add(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
        }

        // copy neighbors
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode origiNode = nodes.get(i);
            UndirectedGraphNode copyNode = map.get(origiNode);
            for (UndirectedGraphNode neighbor : origiNode.neighbors) {
                copyNode.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}
