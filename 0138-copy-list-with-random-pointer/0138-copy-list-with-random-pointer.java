/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head==null) return null;

        Node curr = head;
        HashMap<Node,Node> nodeMap = new HashMap<>();
        while(curr != null){

            Node clonedNode = new Node(curr.val);
            nodeMap.put(curr,clonedNode);
            curr = curr.next;

        }

        curr = head;

        while(curr != null){

            Node clonedNode = nodeMap.get(curr);
            clonedNode.next = nodeMap.get(curr.next);
            clonedNode.random = nodeMap.get(curr.random);
            curr = curr.next;

        }
        return nodeMap.get(head);
    }
}