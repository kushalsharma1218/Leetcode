class LRUCache {
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int size;
    int cap;
    Map<Integer, Node> store = new HashMap<>();
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int key) {
        if(store.containsKey(key))
        {
            Node node = store.get(key);
            deleteNode(node);
            insertAtFirst(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node;
        if(store.containsKey(key))
        {
            node = store.get(key);
            node.value = value;
            deleteNode(node);
        }
        else{
            if(size == cap){
                deleteNode(tail.prev);
            }
            node = new Node(key, value);
        }
        
        insertAtFirst(node);
    }
    public void deleteNode(Node node){
        store.remove(node.key);
        size--;
        Node prev = node.prev;
        Node next = node.next; 
        prev.next = next; 
        next.prev = prev; 
        node.next = null;
        node.prev = null;
        // print();
    }
    public void insertAtFirst(Node node){
        store.put(node.key, node);
        size++;
        Node firstNode = head.next;
        node.next = firstNode;
        node.prev = head;
        firstNode.prev= node;
        head.next = node;
        // print();
    }
    public void print(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.key+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}
class Node{
    int value;
    int key;
    Node next;
    Node prev;
    
    Node(int key, int value){
        this.value = value;
        this.key = key;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */