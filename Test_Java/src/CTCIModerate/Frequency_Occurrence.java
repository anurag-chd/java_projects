package CTCIModerate;

import java.util.*; 

public class Frequency_Occurrence {
	public static void main(String args[]){
		String str1 = " An RFC is  authored by engineers and computer scientists in the form of a memorandum describing methods behaviors research or innovations applicable to the working of the Internet and Internet-connected systems. It is submitted either for peer review or simply to convey new concepts information or  occasionally engineering humor The IETF adopts some of the proposals published as RFCs as Internet standards";
		String str2 = "the";
		//int result = getFrequency(str1,str2);
		getFirstWord(str1);
		//System.out.println(result);
	}
	
	public static void getFirstWord(String str1){
		String str1_arr[] = str1.split(" ");
		StringBuilder s = new StringBuilder();
		for(int i = 0; i< str1_arr.length ;i++){
			if(!str1_arr[i].equals(" ")){
				if(str1_arr[i].length() == 0){
					System.out.println("wtf " +i);
				}
				else if(str1_arr[i].length() == 1){
					s.append(str1_arr[i]);
				}
				else {
					s.append(str1_arr[i].substring(0, 1));
				}
				
			}
		}
		System.out.println(s);
	}
	
	
	public static int getFrequency(String str1, String str2){
		str1 = str1.toLowerCase();
		String str_array[] = str1.split(" ");
		for(int i = 0; i<str_array.length;i++){
			System.out.println(str_array[i]);
		}
		HashMap<String,Integer> map = new HashMap<String,Integer>(); 
	for(String word : str_array){
		if(!map.containsKey(word)){
			map.put(word,1);
		}
		else{
			int count = map.get(word) +1;
			map.put(word,count);
		}
	}
	
	int count = map.get(str2);
	return count;
	
	}
}
