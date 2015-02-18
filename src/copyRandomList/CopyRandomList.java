package copyRandomList;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode node = head;
        // copy nodes
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        // copy the next and random
        node = head;
        while (node != null) {
            RandomListNode cpNode = map.get(node);
            cpNode.next = map.get(node.next);
            cpNode.random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
