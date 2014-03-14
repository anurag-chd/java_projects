package DataStructure;
import java.util.*;
public class Trie {
	TrieNode root;
	
	public Trie(TrieNode root){
		this.root = root;
	}
	
	
	public TrieNode addWord(String word){
		TrieNode temp= null ;
		TrieNode current = root;
		//char c[] = word.toCharArray();
		for(char c : word.toCharArray()){
			if((temp =current.getChildNode(c)) != null ){
				current = current.getChildNode(c);
			}
			else{
				current.getChildren().add(new TrieNode(c));
				System.out.println(current.getC());
				current = current.getChildNode(c);
				System.out.println(current.getC());
			}
			
			
			
		}
		current.setWord(true);
		return root;
		
	}
	
	public void printTrie(TrieNode root){
		HashSet<String> tset = new HashSet<String>();
		StringBuilder sb = new StringBuilder();
		for(TrieNode t : root.getChildren()){
			tset = traverse(t,sb,tset);
			sb.delete(0,sb.length());
		}
		for(String s : tset){
			System.out.println(s);
		}
		
	}	

		
	public HashSet<String> traverse(TrieNode t, StringBuilder sb , HashSet<String> tset){
		int currindex = 0;
		if(t == null){
			return tset;
		}
		if(t.isWord()){
			sb.append(t.getC());
			tset.add(sb.toString());
			return tset;
		}
		else{
			sb.append(t.getC());
			
		}
		for(TrieNode curr: t.getChildren()){
			currindex = sb.length();
			tset =traverse(curr,sb,tset);
			sb.delete(currindex , sb.length());	
		}
		return tset;
		
	}
		
		
				
	
	

}
