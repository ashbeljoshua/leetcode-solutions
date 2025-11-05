class Trie {

    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
       
        
    }
    
    public void insert(String word) {

        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
           if(curr.children[idx] == null){
            curr.children[idx] = new TrieNode();
          
           }
             curr = curr.children[idx];

        }
        curr.isWord = true;

        
    }
    
    public boolean search(String word) {
        TrieNode curr = findWord(word);
        return curr != null && curr.isWord == true;
        
    }
    
    public boolean startsWith(String prefix) {
        return findWord(prefix) != null;
       
        
    }
    public TrieNode findWord(String word){
        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if( curr.children[idx] == null) return null;
            curr = curr.children[idx];
        }
        return curr;
        

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */