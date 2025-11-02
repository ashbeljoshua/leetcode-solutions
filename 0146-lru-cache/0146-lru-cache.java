class LRUCache {

    private static class Node {

        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        
        }
        
    }
    private final Node head;
    private final Node tail;
    private int capacity;
    private final Map<Integer,Node> listMap = new HashMap<>();


    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;


    }
    
    public int get(int key) {

        if(!listMap.containsKey(key)) return -1;

        Node node = listMap.get(key);
        moveNodeToFirst(node);
        return node.value;

        
    }
    
    public void put(int key, int value) {

        if(listMap.containsKey(key)){

            Node node = listMap.get(key);
            node.value = value;
            moveNodeToFirst(node);
            return;
        }

        Node node = new Node(key,value);
        listMap.put(key,node);
        addNodeRightBeforeHead(node);

        if(listMap.size()>capacity){
            evictLastNode();
        }
        
    }

    void moveNodeToFirst(Node node){
      removeNode(node);
       addNodeRightBeforeHead(node);
       
    }
    void addNodeRightBeforeHead(Node node){

         Node firstRealNode = head.next;
        node.next = firstRealNode;
        node.prev = head;
        firstRealNode.prev = node;
        head.next = node;


        
    }
    void removeNode(Node node) {

        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next  = nextNode;
        nextNode.prev = prevNode;
        
    }

    void evictLastNode(){
        Node lru = tail.prev;
        removeNode(lru);
        listMap.remove(lru.key);

    }

    

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */