package DataStructure;

public class TrieDriver {

	public static void main(String args[]){
		Trie triestruct = new Trie(new TrieNode(' '));
		triestruct.addWord("anurag");
		triestruct.addWord("anubhav");
		triestruct.printTrie(triestruct.root);
	}
}
