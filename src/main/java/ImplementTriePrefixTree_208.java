public class ImplementTriePrefixTree_208 {
    class Trie {
        class TrieNode {
            private TrieNode[] children;
            private boolean isWord;

            public TrieNode() {
                children = new TrieNode[26];
                isWord = false;
            }
        }
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }


        public void insert(String word) {
            TrieNode node = root;
            for(int i=0;i<word.length();i++) {
                Character c = word.charAt(i);
                Integer index = c-'a';
                if(node.children[index]==null) {
                    node.children[index]=new TrieNode();
                }
                node = node.children[index];
            }
            node.isWord=true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for(int i=0;i<word.length();i++) {
                Character c = word.charAt(i);
                Integer index = c-'a';
                if(node.children[index]==null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(int i=0;i<prefix.length();i++) {
                Character c = prefix.charAt(i);
                Integer index = c-'a';
                if(node.children[index]==null) {
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }
    }
}
