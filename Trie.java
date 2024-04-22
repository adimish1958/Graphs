package Graph;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26]; // Assuming only lowercase English letters
        this.isEndOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    // Searches for a word in the Trie
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false; // Prefix not found
            }
            current = current.children[index];
        }
        return current != null && current.isEndOfWord; // Returns true if the last node is the end of a word
    }
    
 // Searches for a prefix in the Trie
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false; // Prefix not found
            }
            current = current.children[index];
        }
        return true; // Prefix found
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("hey");
        trie.insert("hi");

        System.out.println(trie.search("hello")); // true
        System.out.println(trie.search("world")); // true
        System.out.println(trie.startsWith("he")); // false
        System.out.println(trie.startsWith("hey")); // true
        System.out.println(trie.startsWith("hi")); // true
        System.out.println(trie.search("h")); // false
    }
}