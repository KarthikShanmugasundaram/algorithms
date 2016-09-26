import java.util.HashMap;
import java.util.Map;

class TrieNode {
    char val;
    Map<Character, TrieNode> children;
    boolean isLeaf;
    
    // Initialize your data structure here.
    public TrieNode(char val) {
        this.val = val;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        } 
        
        Map<Character, TrieNode> children = root.children;
        if (children == null) {
            children = new HashMap<Character, TrieNode>(26);
            root.children = children;
        }
        
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            TrieNode node = children.get(chars[i]);
            if (node == null) {
                node = new TrieNode(chars[i]);
                children.put(chars[i], node);
            }
            
            if (i < chars.length - 1 && node.children == null) {
                node.children = new HashMap<Character, TrieNode>(26);
            }
            
            children = node.children;
            
            if (i == chars.length - 1) {
                node.isLeaf = true;
            } 
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        } 

        Map<Character, TrieNode> children = root.children;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (children == null) {
                return false;
            }
            
            TrieNode node = children.get(chars[i]);
            if (node == null) {
                return false;
            }
            
            children = node.children;
            if (children == null && i < chars.length -1) {
                return false;
            }
            
            if (children != null && (i == chars.length - 1)) {
                if (node.isLeaf) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        } 

        Map<Character, TrieNode> children = root.children;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (children == null) {
                return false;
            }
            
            TrieNode node = children.get(chars[i]);
            if (node == null) {
                return false;
            }
            
            children = node.children;
            if (children == null && i < chars.length -1) {
                return false;
            }
        }
        
        return true;

    }
}