package CTCI;

public class Rep_Space_20 {
	public static void main(String args[]){
		String str = "i love india";
		Rep_Space_20 rs2 = new Rep_Space_20();
		rs2.replace(str);
		//char [] c = str.toCharArray();
		//int length = c.length;
		//rs2.ReplaceFun(c , length);
	}
	
	public void replace(String str){
		int space_count =0 ;
		char [] char_set = str.toCharArray();
		int length = str.length();
		for(int i =0 ; i < length ; i++){
			if(char_set[i] == ' ')
				space_count++;
		}
		
		int newlength = length + (2 * space_count);
		char [] char_set2 = new char[newlength];
		//char_set2[newlength] = '\0';
		for(int i = length -1 ;i>=0;i--){
			if(char_set[i] == ' '){
				char_set2[newlength - 1] ='0';
				char_set2[newlength - 2] ='2';
				char_set2[newlength - 3] ='%';
				newlength = newlength - 3;
			}
			else{
				char_set2[newlength - 1] =char_set[i];
				newlength = newlength -1;
			}
			
		}
		
		for(int k = 0 ; k < char_set2.length; k++){
			System.out.print(char_set2[k]);
	 
	}
	}
	
	
	
	
	public static void ReplaceFun(char[] str, int length) {
		 int spaceCount = 0, newLength, i = 0;
		 for (i = 0; i < length; i++) {
		 if (str[i] == ' ') {
		 spaceCount++;
		 }
		 }
		 newLength = length + spaceCount * 2;
		 str[newLength] = '\0';
		 for (i = length - 1; i >= 0; i--) {
		 if (str[i] == ' ') {
		 str[newLength - 1] = ' ';
		 str[newLength - 2] = '2';
		 str[newLength - 3] = '%';
		 newLength = newLength - 3;
		 } else {
		 str[newLength - 1] = str[i];
		 newLength = newLength - 1;
		 }
		 }
	 for(int k = 0 ;k< newLength ;k++){
		 System.out.println(str[k]);
	 }
	
	}
	
	

}
