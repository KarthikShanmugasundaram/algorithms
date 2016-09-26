import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    private int capacity = 0;
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head;
    private Node end;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            
            return node.value;
        }
        
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            
            remove(node);
            setHead(node);
        } else {
            Node newNode = new Node(key, value);
            if (capacity <= map.size()) {
                map.remove(end.key);
                remove(end);
            }
            setHead(newNode);
            map.put(key, newNode);
        }
    }
    
    private void remove(Node node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        
        if (node.next == null) {
            end = node.prev;

        } else {
            node.next.prev = node.prev;
        }
    }
    
    private void setHead(Node node) {
        node.next = head;
        node.prev = null;
        
        if (head != null) {
            head.prev = node;
        }
        
        head = node;
        
        if (end == null) {
            end = head;
        }
    }
    
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}