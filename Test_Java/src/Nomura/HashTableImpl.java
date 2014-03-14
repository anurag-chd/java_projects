package Nomura;
import java.util.*;

public class HashTableImpl {
	private class HashNode{
		Object key;
		Object value;
		
		public HashNode(){
			this.key = null;
			this.value = null;
		}
		
		public HashNode(Object key, Object value){
			this.key = key;
			this.value = value;
		}
		
		public Object getKey() {
			return key;
		}
		public void setKey(Object key) {
			this.key = key;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
		
		public boolean equals(Object obj){
			if(obj instanceof HashNode){
				HashNode node = (HashNode)obj;
				return this.getKey().equals(node.getKey());
			}
			else{
				return false;
			}
		}
		
		public String toString(){
			return ("Key: "+ this.getKey() + "; Value: " + this.getValue());
		}
		
	}
	
	
	
	private final int table_size = 20;
	private int numElements = 0;
	private Object[] table = new Object[table_size];
	
	/*public HashTableImpl(Object key, Object value){
		
	}
	*/
	
	
	private int hash(Object key){
		String str = key.toString();
		char [] char_arr = str.toCharArray();
		int result = 0;
		/*for(int i =0;i<str.length();i++){
			result = result + Integer.parseInt(str,i);
		}*/
		for(int i =0;i<str.length();i++){
			result = result + (int)char_arr[i];
		}
		return (result%this.table_size);
	}
	
	
	public void add(Object key,Object value){
		if(key == null || value == null){
			return ;
		}
		else{
			if(this.contains(key)){
				System.out.println("Duplicate key");
				return;
			}
			HashNode node = new HashNode(key,value);
			int hashvalue = hash(node.getKey());
			if(table[hashvalue]!=null){
				((LinkedList)this.table[hashvalue]).add(node);
				this.numElements ++;
			}
			else{
				LinkedList list = new LinkedList();
				list.add(node);
				this.table[hashvalue] = list;
				this.numElements ++;
			}
		}
		
		
	}
	
	public boolean contains(Object key){
		if(key == null){
			return false;
		}
		else{
			int hashval = this.hash(key);
			if(this.table[hashval]!=null){
				HashNode node = new HashNode();
				node.setKey(key);
				
				if(((LinkedList)this.table[hashval]).indexOf(node)>-1){
					return true;
					
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
	}
	
	public Object get(Object key){
		if(key == null){
			return null;
		}
		else{
			int pos = hash(key);
			if(this.table[pos] == null){
				return null;
			}
			else{
				HashNode node = new HashNode();
				node.setKey(key);
				HashNode temp;
				int link_pos = ((LinkedList)this.table[pos]).indexOf(node);
				if(link_pos > -1){
					temp = (HashNode)((LinkedList)this.table[pos]).get(link_pos);
					return temp.getValue();
				}
				else{
					return null;
				}
			}
		
		
		
		}
		
	}
	public void remove(Object key){
		if(key == null){
			return;
		}
		else{
			int pos = this.hash(key);
			if(this.table[pos] == null){
				return ;
			}
			else{
				HashNode node = new HashNode();
				node.setKey(key);
				HashNode temp;
				int link_pos = ((LinkedList)this.table[pos]).indexOf(node);
				if(link_pos > -1){
					temp = (HashNode)((LinkedList)this.table[pos]).remove(link_pos);
					return;
				}
				else{
					return ;
				}
			}
		}
	}

}
