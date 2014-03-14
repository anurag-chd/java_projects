package DataStructure;
import java.util.*;
public class TrieNode {

	private char c;
	private List<TrieNode> children;
	private boolean isWord = false;
	//private boolean isPrefix ;
	
	public TrieNode(char c){
		this.c = c;
		this.children = new ArrayList<TrieNode>();
		isWord = false;
	}
	
	public void addChild(TrieNode child){
		this.children.add(child);
	}
	
	public TrieNode getChildNode(char c){
		for(TrieNode t : children){
			if(t.getC() == c){
				return t;
			}
						
		}
		System.out.println("No child of following character");
		return null;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	public List<TrieNode> getChildren() {
		return children;
	}

	public void setChildren(List<TrieNode> children) {
		this.children = children;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
	
	
}
