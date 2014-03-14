package PracticeQues;
import java.util.*;

public class StringRev {
	public static void main(String args[]){
		String str = "The sky is blue";
		StringRev rev = new StringRev();
		rev.go(str);
	}
	public void go(String str){
		char arr[] = str.toCharArray();
		StringBuilder br = new StringBuilder();
		ArrayList<String> strarr = new ArrayList<String>();
		int j = 0;
		for(int i = 0; i<arr.length;i++){
			if(i == arr.length-1){
				br= br.append(arr[i]);
				strarr.add(br.toString());
			}
			
			if(arr[i] == ' '){
				
			strarr.add(br.toString());
			//System.out.println(strarr.get(j));
			j++;
			br.delete(0, br.length());
			}
			else{
				br = br.append(arr[i]);
			}
		}
		for(int i = strarr.size()-1; i>=0; i--){
			System.out.println(strarr.get(i));
		}
		
		
		/*String[] new_str = str.split(" ");
		for(int i = new_str.length-1; i>=0;i--){
			System.out.println(new_str[i]);
		}*/
	}
	

}
