package Basics;

public class HashMap1 {
	HashList[] hasharr = new HashList[10];
	
	public HashMap1(){
		for (int i = 0;i<10;i++){
			hasharr[i] = new HashList();
		}
	}
	
	public void add(int num){
		int key = (num % 10);
		hasharr[key].insert(key,num);
	}
	
	public void displayKeyList(int key){
		hasharr[key].showList();
	}

}
